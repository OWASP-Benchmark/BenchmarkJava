/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.owasp.benchmark.score.parsers.AppscanReader;
import org.owasp.benchmark.score.parsers.ArachniReader;
import org.owasp.benchmark.score.parsers.BurpReader;
import org.owasp.benchmark.score.parsers.CheckmarxReader;
import org.owasp.benchmark.score.parsers.Counter;
import org.owasp.benchmark.score.parsers.CoverityReader;
import org.owasp.benchmark.score.parsers.FindbugsReader;
import org.owasp.benchmark.score.parsers.FortifyReader;
import org.owasp.benchmark.score.parsers.OverallResults;
import org.owasp.benchmark.score.parsers.PMDReader;
import org.owasp.benchmark.score.parsers.ParasoftReader;
import org.owasp.benchmark.score.parsers.Reader;
import org.owasp.benchmark.score.parsers.SonarQubeLegacyReader;
import org.owasp.benchmark.score.parsers.SonarQubeReader;
import org.owasp.benchmark.score.parsers.TestCaseResult;
import org.owasp.benchmark.score.parsers.TestResults;
import org.owasp.benchmark.score.parsers.VeracodeReader;
import org.owasp.benchmark.score.parsers.ZapReader;
import org.owasp.benchmark.score.report.Report;
import org.owasp.benchmark.score.report.ScatterScores;
import org.owasp.benchmark.score.report.ScatterVulns;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class BenchmarkScore {

	private static final String GUIDEFILENAME = "OWASP_Benchmark_Guide.html";
	private static final String HOMEFILENAME = "OWASP_Benchmark_Home.html";    
    public static final String pathToScorecardResources = "src/main/resources/scorecard/";
    public static final String scoreCardDirName = "scorecard";
    public static String benchmarkVersion;
	
	
	/*
	 * A list of the reports produced for each tool.
	 */
	private static List<Report> toolResults = new ArrayList<Report>();
	
	public static void main(String[] args) {
		if ( args == null || args.length < 2 ) {
			System.out.println( "Usage: BenchmarkScore expected actual" );
			System.out.println( "  expected - path of expected results from Benchmark distribution" );
			System.out.println( "  actual   - directory with result files from tool (.ozasmt, .fpr, .fvdl, findbugs.xml, pmd.xml, etc..." );
			System.out.println();
			System.exit( -1 );
		}
		
        java.util.Properties benchmarkprops = new java.util.Properties();
        try {
            benchmarkprops.load(BenchmarkScore.class.getClassLoader().getResourceAsStream("benchmark.properties"));
            benchmarkVersion = benchmarkprops.getProperty("benchmark-version");
        } catch (IOException e) {
            System.out.println("Error!! - can't access benchmark.properties.");
            e.printStackTrace();
        }
		
        File scoreCardDir = new File(scoreCardDirName);
        try {
            if (!scoreCardDir.exists()) {
                Files.createDirectories(Paths.get(scoreCardDirName));
            } else {
                System.out.println("Deleting previously generated scorecard files in: " + scoreCardDir.getAbsolutePath());
                FileUtils.cleanDirectory(scoreCardDir);
            }
            
            // now copy the entire /content directory, that either didn't exist, or was just deleted with everything else
            File dest1 = new File(scoreCardDirName + File.separator + "content");
            FileUtils.copyDirectory(new File(pathToScorecardResources + "content"), dest1);
            
        } catch (IOException e) {
            System.out.println("Error dealing with scorecard directory: '" + scoreCardDir.getAbsolutePath() + "' for some reason!");
            e.printStackTrace();
        }

        
	    // copy over the homepage and guide templates
        try {
            Files.copy(Paths.get(pathToScorecardResources + HOMEFILENAME),
                    Paths.get( scoreCardDirName + "/" + HOMEFILENAME),
                    StandardCopyOption.REPLACE_EXISTING );
            
            Files.copy(Paths.get(pathToScorecardResources + GUIDEFILENAME),
                    Paths.get( scoreCardDirName + "/" + GUIDEFILENAME),
                    StandardCopyOption.REPLACE_EXISTING );
        } catch( IOException e ) {
            System.out.println( "Problem copying home and guide files" );
            e.printStackTrace();
        }

		
		try {
			File expected = new File( args[0] );
			TestResults expectedResults = readExpectedResults( expected );
			if (expectedResults == null) {
				System.out.println( "Couldn't read expected results file: " + expected);
				System.exit(-1);
			} else {
				System.out.println( "Read expected results from file: " + expected.getAbsolutePath());
				int totalResults = expectedResults.totalResults();
				if (totalResults != 0) {
					System.out.println( totalResults + " results found.");
				} else {
					System.out.println( "Error! - zero expected results found in results file.");
					System.exit(-1);
				}
			}
		
			File f = new File( args[1] );
			if (!f.exists()) {
				System.out.println( "Error! - results file: '" + f.getAbsolutePath() + "' doesn't exist.");
				System.exit(-1);
			}
			if ( f.isDirectory() ) {
    			for ( File actual : f.listFiles() ) {
    				// Don't confuse the expected results file as an actual results file if its in the same directory
    				
    				//actual
    				if (!actual.isDirectory() && !expected.getName().equals(actual.getName()))
    					process( actual, expectedResults, toolResults);
    			}
    			//expected
			} else {
			    process( f, expectedResults, toolResults );
			}
			
			System.out.println( "Tool scorecards computed." );
		} catch( Exception e ) {
			System.out.println( "Error during processing: " + e.getMessage() );
			e.printStackTrace();
		}

		// Generate vulnerability category list
        // A set is used here to eliminate duplicate categories across all the results
        Set<String> catSet = new HashSet<String>();
        for ( int i= 0; i < toolResults.size(); i++ ) {
            Report toolReport = toolResults.get(i);
            catSet.addAll( toolReport.getOverallResults().getCategories() );
        }
        
        List<String> catList = new ArrayList<String>();
        catList.addAll(catSet);
        
		
		// Generate vulnerability pages
//        System.out.println("generating vulns");
        BenchmarkScore.generateVulnerabilityScorecards(toolResults, catList);
		System.out.println( "Vulnerability scorecards computed." );
        		
		updateMenus(toolResults, catList);
		
        // Generate the overall comparison chart for all the tools in this test
        ScatterScores.generateComparisonChart(toolResults);
		System.out.println( "Benchmark scorecards complete." );
       
		System.exit(0);
	}

	/**
	 * The method takes in a tool scan results file and determined how well that tool did against the benchmark.
	 * @param f - The results file to process. This is the native results file from the tool.
	 * @param expectedResults - This is the expected results csv file for this version of the Benchmark.
	 * @param toolResults - This list contains some information about the results for each tool. It is updated
	 * in this method so that the menus across all the scorecards can be generated and an summary scorecard can be
	 * computed. A new entry is added each time this method is called which adds the name of the tool, the filename of the
	 * scorecard, and the report that was created for that tool.
	 */
	private static void process(File f, TestResults expectedResults, List<Report> toolreports) {
        try {
        	// Figure out the actual results for this tool from the raw results file for this tool            
            System.out.println( "\nAnalyzing results from " + f.getName() );
            TestResults actualResults = readActualResults( f );
        
            if ( expectedResults != null && actualResults != null ) {
                // note: side effect is that "passed" is filled into expected results
                analyze( expectedResults, actualResults );
            
                // Produce a .csv results file of the actual results
                String actualResultsFileName = produceResultsFile (expectedResults);
                
                Map<String,Counter> scores = calculateScores( expectedResults );
            
                OverallResults results = calculateResults( scores );
                results.setTime( actualResults.getTime() );
                
                
                // This generates the report on disk.
                Report scoreCard = new Report( actualResults, scores, results, expectedResults.totalResults(), actualResultsFileName,actualResults.isCommercial,true);
                
                // Add this report to the list of reports
                toolreports.add(scoreCard);
                
                // This is for debugging purposes. It indicates how may extra results were found in the
                // actual results vice the expected results.
                // printExtraCWE( expectedResults, actualResults );
            }
            else {
            	if ( expectedResults == null) {
                	System.out.println("Error!!: expected results were null.");
            	}
            	else System.out.println("Error!!: actual results were null for file: " + f);
            }
        }
        catch( Exception e ) {
            System.out.println( "Error processing " + f + ". Continuing." );
            e.printStackTrace();
        }
    }

	// Don't delete - for debug purposes
    private static void printExtraCWE(TestResults expectedResults, TestResults actualResults) {
        Set<Integer> expectedCWE = new HashSet<Integer>();
        for ( int i : expectedResults.keySet() ) {
            List<TestCaseResult> list = expectedResults.get( i );
            for ( TestCaseResult t : list ) {
                expectedCWE.add( t.getCWE() );
            }
        }
        
        Set<Integer> actualCWE = new HashSet<Integer>();
        for ( int i : actualResults.keySet() ) {
            List<TestCaseResult> list = actualResults.get( i );
            if ( list != null ) {
                for ( TestCaseResult t : list ) {
                    actualCWE.add( t.getCWE() );
                }
            }
        }
        
        Set<Integer> extras = difference( actualCWE, expectedCWE );
        for ( int cwe : extras ) {
            System.out.println( "Extra: "+cwe );
        }
    }

    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new HashSet<T>(setA);
        tmp.removeAll(setB);
        return tmp;
    }
    
    private static OverallResults calculateResults(Map<String, Counter> results) {
		OverallResults or = new OverallResults();
		double totalScore = 0;
		double totalFPRate = 0;
		double totalTPRate = 0;
		for ( String category : results.keySet() ) {
			Counter c = results.get( category );			
			int total = (int)c.tp + (int)c.fn + (int)c.tn + (int)c.fp;
			double tpr = c.tp / ( c.tp + c.fn );
			double fpr = c.fp / ( c.fp + c.tn );
//			double fdr = c.fp / ( c.tp + c.fp );
            
            // category score is distance from (fpr,tpr) to the guessing line
            double side = tpr - fpr;
            double hyp = side * Math.sqrt(2); // Pythagoras
            double raw = hyp/2;
            double score = raw * Math.sqrt(2); // adjust scores to 0-1
            
            if ( !Double.isNaN(score)) {
                totalScore += score;
            }
            totalFPRate += fpr;
            totalTPRate += tpr;
            
            or.add( category, tpr, fpr, total, score );
		}
		
		int resultsSize = results.size();
		or.setScore( totalScore / resultsSize );
		or.setFalsePositiveRate( totalFPRate / resultsSize );
		or.setTruePositiveRate( totalTPRate / resultsSize );
		
		return or;
	}

	public static String translate(String category) {
		switch( category ) {
		case "cmdi" : return "Command Injection";
		case "xss" : return "Cross-Site Scripting";
		case "ldapi" : return "LDAP Injection";
		case "headeri" : return "Header Injection";
		case "securecookie" : return "Insecure Cookie";
		case "pathtraver" : return "Path Traversal";
		case "crypto" : return "Weak Encryption Algorithm";
		case "hash" : return "Weak Hash Algorithm";
		case "weakrand" : return "Weak Random Number";
		case "sqli" : return "SQL Injection";
		case "trustbound" : return "Trust Boundary Violation";
		case "xpathi" : return "XPath Injection";
		default : return "Unknown Vulnerability: " + category;
		}
	}

	/**
	 * Return map of category to array of results
	 * @param expectedResults
	 * @return
	 */
	private static Map<String,Counter> calculateScores(TestResults expectedResults) {
		Map<String,Counter> map = new TreeMap<String,Counter>();
		
		for ( Integer tn : expectedResults.keySet() ) {
			TestCaseResult tcr = expectedResults.get(tn).get(0); // only one
			String cat = translate( tcr.getCategory() );

			Counter c = map.get(cat);
			if ( c == null ) {
				c = new Counter();
				map.put(cat, c);
			}
			// real vulnerabilities
			if ( tcr.isReal() && tcr.isPassed() ) c.tp++; // tp
			else if ( tcr.isReal() && !tcr.isPassed() ) c.fn++; // fn
			
			// fake vulnerabilities
			else if (!tcr.isReal() && tcr.isPassed() ) c.tn++;  // tn
			else if (!tcr.isReal() && !tcr.isPassed() ) c.fp++; // fp
		}
		return map;
	}


	private static TestResults readActualResults(File actual) throws Exception {
		String filename = actual.getName();
		TestResults tr = null;
        
        if ( filename.endsWith(".ozasmt" ) ) {
            tr = new AppscanReader().parse( actual );
        }      
        
        else if ( filename.endsWith(".json" ) ) {
            String line1 = getLine( actual, 0 );
            String line2 = getLine( actual, 1 );
            if ( line2.contains("formatVersion")) {
                tr = new CoverityReader().parse( actual );
            }
            
            else {
                tr = new SonarQubeReader().parse( actual );
            }
        }
        
		else if ( filename.endsWith( ".xml" ) ) {
            String line1 = getLine( actual, 0 );
            String line2 = getLine( actual, 1 );
		    if ( line2.startsWith( "<pmd")) {
                tr = new PMDReader().parse( actual );
		    }
		    
            else if ( line2.startsWith( "<BugCollection")) {
                tr = new FindbugsReader().parse( actual );
                
                // change the name of the tool if the filename contains findsecbugs
                if (actual.getName().contains("findsecbugs")) {
                    tr.setTool("FBwFindSecBugs");
                }
            }

            else if ( line2.startsWith( "<ResultsSession")) {
                tr = new ParasoftReader().parse( actual );
            }

            else if ( line2.startsWith( "<detailedreport")) {
                tr = new VeracodeReader().parse( actual );
            }

            else if ( line1.startsWith( "<total")) {
                tr = new SonarQubeLegacyReader().parse( actual );
            }
            
            else if ( line1.contains( "<OWASPZAPReport") || line2.contains( "<OWASPZAPReport")) {
                tr = new ZapReader().parse( actual );
            }
            
            else if ( line2.startsWith( "<CxXMLResults")) {
                tr = new CheckmarxReader().parse( actual );
            }
            
            else if ( line2.startsWith( "<report")) {
                tr = new ArachniReader().parse( actual );
            }
		    
            else {
                Document doc = getXMLDocument( actual );
                Node root = doc.getDocumentElement();
                if ( root.getNodeName().equals( "issues" ) ) {
                    tr = new BurpReader().parse( doc );
                }
            }
		}
		
		else if ( filename.endsWith( ".fpr" ) ) {
			Path path = Paths.get(actual.getPath());
		    FileSystem fileSystem = FileSystems.newFileSystem(path, null);
		    File outputFile = File.createTempFile( filename, ".fvdl");
		    Path source = fileSystem.getPath("audit.fvdl");
		    Files.copy(source, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			tr = new FortifyReader().parse( outputFile );
		}
		
        else if ( filename.endsWith( ".fvdl" ) ) {
            tr = new FortifyReader().parse( actual );
        }
        
        // If the version # of the tool is specified in the results file name, extract it, and set it.
        // For example: Benchmark-1.1-Coverity-results-v1.3.2661-6720.json  (the version # is 1.3.2661 in this example). 
        // This code should also handle: Benchmark-1.1-Coverity-results-v1.3.2661.xml (where the compute time '-6720' isn't specified)
        int indexOfVersionMarker = filename.lastIndexOf("-v");
        if ( indexOfVersionMarker != -1) {
        	String restOfFileName = filename.substring(indexOfVersionMarker+2);
        	int endIndex = restOfFileName.lastIndexOf('-');
        	if (endIndex == -1) endIndex = restOfFileName.lastIndexOf('.');
        	String version = restOfFileName.substring(0, endIndex);
        	tr.setToolVersion(version);
        }
        
		return tr;
	}

	/**
	 * Read the 2nd line of the provided file. If its blank, skip all blank lines until a non-blank line
	 * is found and return that. Return "" if no none blank line is found from the second line on.
	 * @return The first non-blank line in the file starting with the 2nd line.
	 */
	private static String getLine(File actual, int line) {
		BufferedReader br = null;
		try {
    	    br = new BufferedReader( new FileReader( actual ) );
    	    for ( int i=0; i<line; i++ ) {
    	        br.readLine(); // Skip line 1
    	    }
    	    String line2 = "";
    	    while ( line2.equals( "" ) ) {
    	        line2 = br.readLine();
    	    }
    	    return line2;
	    } catch( Exception e ) {
	        return "";
	    } finally {
	    	try {
		    	if (br != null) br.close();	    		
	    	} catch (IOException e) {
	    		System.out.println("Can't close filereader for file: " + actual.getAbsolutePath() + 
	    			" for some reason.");
	    		e.toString();
	    	}
	    }
    }

    private static void analyze( TestResults expected, TestResults actual ) {
		boolean pass = false;
		for ( int tc : expected.keySet() ) {
			TestCaseResult exp = expected.get( tc ).get(0); // always only one!
			List<TestCaseResult> act = actual.get( tc );  // could be lots of results for this test
				
			pass = compare( exp, act, actual.getTool() );

			// helpful in debugging
			//System.out.println( tc + ", " + exp.getCategory() + ", " + exp.isReal() + ", " + exp.getCWE() + ", " + pass + "\n");
			
			// fill the result into the "expected" results in case we need it later
			exp.setPassed( pass );
		}
		
		// Record the name and version of the tool whose pass/fail values were recorded in 'expected' results
		expected.setTool(actual.getTool());
		expected.setToolVersion(actual.getToolVersion());
	}
	
	/**
	 * Check all actual results. If a real vulnerability matches, then exit. Otherwise keep going.
	 * @param exp The expected results
	 * @param actList The list of actual results for this test case.
	 * @return true if the expected result is found in the actual result (i.e., If True Positive, 
	 * that results was found, If False Positive, that result was not found.)
	 */
	private static boolean compare( TestCaseResult exp, List<TestCaseResult> actList, String tool ) {
		// return true if there are no actual results and this was a fake test
		if ( actList == null || actList.isEmpty() ) {
			return !exp.isReal();
		}
		
		// otherwise check actual results
		for ( TestCaseResult act : actList ) {
			// Helpful in debugging
		    //System.out.println( "  Evidence: " + act.getCWE() + " " + act.getEvidence() + "[" + act.getConfidence() + "]");
			
		    boolean match = act.getCWE() == exp.getCWE();
			
			// special hack since IBM/Veracode don't distinguish different kinds of weak algorithm
			if ( tool.startsWith("AppScan") || tool.startsWith("Vera")) {
			    if ( exp.getCWE() == 328 && act.getCWE() == 327 ) {
			        match = true;
			    }
			}
					
			// return true if we find an exact match for a real test
			if ( match ) {
				return exp.isReal();
			}
		}
		// if we couldn't find a match, then return true if it's a fake test
		return !exp.isReal();
	}

	
	private static TestResults readExpectedResults(File f1) throws Exception {
		TestResults tr = new TestResults( "Expected" ,true,null);
		BufferedReader fr = new BufferedReader( new FileReader( f1 ) );
		boolean reading = true;
		while ( reading ) {
			String line = fr.readLine();
			reading = line != null;
			if ( reading ) {
				String[] parts = line.split(",");
				if ( parts[0] != null && parts[0].startsWith("Bench" ) ) {
					TestCaseResult tcr = new TestCaseResult();
					tcr.setTestCaseName(parts[0]);
					tcr.setCategory( parts[1]);
					tcr.setReal( Boolean.parseBoolean( parts[2] ) );
					tcr.setCWE( Integer.parseInt( parts[3]) );

					String tcname = parts[0].substring( "BenchmarkTest".length() );
					tcr.setNumber( Integer.parseInt(tcname));
					
					tr.put( tcr );
				}
			}
		}
		fr.close();
		return tr;
	}
	
	/**
	 * This produces the .csv of all the results for this tool. It's basically the expected results file
	 * with a couple of extra columns in it to say what the actual result for this tool was per test case
	 * and whether that result was a pass or fail.
	 * @param actual The actual TestResults to produce the actual results file for.
	 * @return The name of the results file produced
	 */
	private static String produceResultsFile( TestResults actual ) {
		
		File resultsFile = null;
		PrintStream ps = null;
		
		try {
			resultsFile = new File(scoreCardDirName + File.separator + "Benchmark_v" 
					+ benchmarkVersion + "_Scorecard_for_" + actual.getTool().replace( ' ', '_' )
					+ ".csv");
			FileOutputStream fos = new FileOutputStream(resultsFile, false);
			ps = new PrintStream(fos);
	
			// Write actual results header
			ps.print("# test name, category, real vulnerability, CWE, identified by tool, pass/fail");

			// Add the version # inside the file as well
			ps.print(", Benchmark version: " + benchmarkVersion);
			
			// Append the date YYYY-MM-DD to the header in each .csv file
			Calendar c = Calendar.getInstance();
			String s = String.format("%1$tY-%1$tm-%1$te", c);
			ps.println(", Actual results generated: " + s);
	
			Set<Integer> testCaseKeys = actual.keySet();
			
			for (Integer expectedResultsKey : testCaseKeys) {
				// Write meta data to file here.
				TestCaseResult actualResult = actual.get(expectedResultsKey.intValue()).get(0);
				ps.print(actualResult.getName());
				ps.print(", " + actualResult.getCategory());
				boolean isreal = actualResult.isReal();
				ps.print(", " + isreal);
				ps.print(", " + actualResult.getCWE());
				boolean passed = actualResult.isPassed();
				boolean toolresult = !(isreal^passed);
				ps.print(", " + toolresult );
				ps.println(", " + (passed ? "pass" : "fail"));
			}
			
			System.out.println("Actual results file generated: " + resultsFile.getAbsolutePath());
			
			return resultsFile.getName();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Can't create actual results file: " + resultsFile.getAbsolutePath());
		} finally {
			if (ps != null) ps.close();
		}
		
		return null; // Should have returned results file name earlier if successful
		
	}
	
	private static void generateVulnerabilityScorecards( List<Report> toolResults, List<String> catSet ) {
		Collections.sort(catSet);
        for (String cat : catSet ) {
            try {
                ScatterVulns.generateComparisonChart(cat, toolResults);
                String filename = "Benchmark_v" + benchmarkVersion + "_Scorecard_for_" + cat.replace(' ', '_');  
                Path htmlfile = Paths.get( scoreCardDirName + "/" + filename + ".html" );
                Files.copy(Paths.get(pathToScorecardResources + "vulntemplate.html" ), htmlfile, StandardCopyOption.REPLACE_EXISTING );
                String html = new String(Files.readAllBytes( htmlfile ) );
                String fullTitle = "OWASP Benchmark Scorecard for " + cat;

                html = html.replace("${image}", filename + ".png" );
                html = html.replace( "${title}", fullTitle );
                html = html.replace( "${vulnerability}", cat );
                html = html.replace( "${version}", benchmarkVersion );
                Files.write( htmlfile, html.getBytes() );                
            } catch( IOException e ) {
                System.out.println( "Error generating vulnerability summaries: " + e.getMessage() );
                e.printStackTrace();
            }
        }
	}
	
	
	/**
	 * This method updates the menus of all the scorecards previously generated so people can navigate
	 * between all the tool results.
	 */
	private static void updateMenus(List<Report> toolResults, List<String> catSet ) {

        // Create tool menu
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < toolResults.size(); i++) {
            Report toolReport = toolResults.get(i);
            sb.append("            <li><a href=\"");
            sb.append(toolReport.getFilename());
            sb.append(".html\">");
            sb.append(toolReport.getToolName());
            sb.append("</a></li>");
            sb.append(System.lineSeparator());
        }        
        String toolmenu = sb.toString();

        
        // create vulnerability menu
        sb = new StringBuffer();
        for (String cat : catSet ) {
            String filename = "Benchmark_v" + benchmarkVersion+"_Scorecard_for_" +cat.replace(' ', '_');  
            sb.append("            <li><a href=\"");
            sb.append( filename );
            sb.append(".html\">");
            sb.append( cat );
            sb.append("</a></li>");
            sb.append(System.lineSeparator());
        }
        String vulnmenu = sb.toString();
        
		// rewrite HTML files with new menus
		updateMenuTemplates( toolmenu, vulnmenu );        
	}
	
	private static void updateMenuTemplates( String toolmenu, String vulnmenu ) {
	    File root = new File( scoreCardDirName );
	    for ( File f : root.listFiles() ) {
	        if ( !f.isDirectory() && f.getName().endsWith( ".html" ) ) {
	            try {
    	            String html = new String( Files.readAllBytes( f.toPath() ) );
    	            html = html.replace("${toolmenu}", toolmenu);
    	            html = html.replace("${vulnmenu}", vulnmenu);
    	            html = html.replace( "${version}", benchmarkVersion );
    	            Files.write( f.toPath(), html.getBytes() );
	            } catch ( IOException e ) {
	                System.out.println ( "Error updating menus in: " + f.getName() );
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	private static Document getXMLDocument( File f ) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource(new FileInputStream(f));
        Document doc = docBuilder.parse(is);
        return doc;
	}
	
}
