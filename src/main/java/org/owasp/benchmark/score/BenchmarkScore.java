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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.owasp.benchmark.score.parsers.AppscanReader;
import org.owasp.benchmark.score.parsers.Counter;
import org.owasp.benchmark.score.parsers.CoverityReader;
import org.owasp.benchmark.score.parsers.FindbugsReader;
import org.owasp.benchmark.score.parsers.FortifyReader;
import org.owasp.benchmark.score.parsers.OverallResults;
import org.owasp.benchmark.score.parsers.PMDReader;
import org.owasp.benchmark.score.parsers.ParasoftReader;
import org.owasp.benchmark.score.parsers.TestCaseResult;
import org.owasp.benchmark.score.parsers.TestResults;
import org.owasp.benchmark.score.parsers.VeracodeReader;
import org.owasp.benchmark.score.report.Report;
import org.owasp.benchmark.score.report.ScatterScores;
import org.owasp.benchmark.score.report.ScatterVulns;

public class BenchmarkScore {

	private static final String GUIDEFILENAME = "OWASP_Benchmark_Guide.html";
	private static final String HOMEFILENAME = "OWASP_Benchmark_Home.html";
	
	/*
	 * A list of the reports produced for each tool.
	 */
	private static List<Report> toolResults = new ArrayList();
	
	public static void main(String[] args) {
		if ( args == null || args.length < 2 ) {
			System.out.println( "Usage: BenchmarkScore expected actual" );
			System.out.println( "  expected - path of expected results from Benchmark distribution" );
			System.out.println( "  actual   - directory with result files from tool (.ozasmt, .fpr, .fvdl, findbugs.xml, pmd.xml, etc..." );
			System.out.println();
			System.exit( -1 );
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
    				if (!expected.getName().equals(actual.getName()))
    					process( actual, expectedResults, toolResults );
    			}
			} else {
			    process( f, expectedResults, toolResults );
			}
			
			System.out.println( "Benchmark scorecards computed." );
		} catch( Exception e ) {
			System.out.println( "Error during processing: " + e.getMessage() );
			e.printStackTrace();
		}
		
		// Update the menus for each of the scorecard HTML files
		updateMenus(toolResults);
		
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
                Report scoreCard = new Report( actualResults, scores, results, expectedResults.totalResults(), 
                		actualResultsFileName );
                
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
		case "xss" : return "Cross Site Scripting";
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
            tr.setTool( "AppScan Source");
        }
        
        
        else if ( filename.endsWith(".json" ) ) {
            tr = new CoverityReader().parse( actual );
            tr.setTool( "Coverity");
        }
        
		else if ( filename.endsWith( ".xml" ) ) {
		    String line = getLine2( actual );
		    if ( line.startsWith( "<pmd")) {
                tr = new PMDReader().parse( actual );
                tr.setTool( "PMD");
		    }
		    
            else if ( line.startsWith( "<BugCollection")) {
                tr = new FindbugsReader().parse( actual );
                if (actual.getName().contains("findsecbugs")) {
                    tr.setTool("FBwFindSecBugs");
                } else {
                    tr.setTool( "FindBugs");
                }
            }

            else if ( line.startsWith( "<ResultsSession")) {
                tr = new ParasoftReader().parse( actual );
                tr.setTool( "Parasoft");
            }

	        else if ( line.startsWith( "<detailedreport")) {
                tr = new VeracodeReader().parse( actual );
                tr.setTool( "Veracode");
	        }
		}
		
		else if ( filename.endsWith( ".fpr" ) ) {
			Path path = Paths.get(actual.getPath());
		    FileSystem fileSystem = FileSystems.newFileSystem(path, null);
		    File outputFile = File.createTempFile( filename, ".fvdl");
		    Path source = fileSystem.getPath("audit.fvdl");
		    Files.copy(source, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			tr = new FortifyReader().parse( outputFile );
            tr.setTool( "Fortify");
		}
		
        else if ( filename.endsWith( ".fvdl" ) ) {
            tr = new FortifyReader().parse( actual );
            tr.setTool( "Fortify");
        }
        
		if ( tr != null ) {
		    System.out.println( "Analyzing " + tr.getTool() + " results from " + filename );
		}
		return tr;
	}

	/**
	 * Read the 2nd line of the provided file. If its blank, skip all blank lines until a non-blank line
	 * is found and return that. Return "" if no none blank line is found from the second line on.
	 * @return The first non-blank line in the file starting with the 2nd line.
	 */
	private static String getLine2(File actual) {
		BufferedReader br = null;
		try {
    	    br = new BufferedReader( new FileReader( actual ) );
    	    br.readLine(); // Skip line 1
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
		
		// Record the name of the tool whose pass/fail values were recorded in 'expected' results
		expected.setTool(actual.getTool());
	}
	
	/**
	 * Check all actual results. If a real vulnerability matches, then exit. Otherwise keep going.
	 * @param exp
	 * @param actList
	 * @return
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
		TestResults tr = new TestResults();
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
	 * 
	 * @param actual The actual TestResults to produce the actual results file for.
	 * @return The name of the results file produced
	 */
	private static String produceResultsFile( TestResults actual ) {
		
		File resultsFile = null;
		PrintStream ps = null;
		
		try {
			resultsFile = new File(Report.scoreCardDirName + File.separator + "OWASP_Benchmark_v" 
					+ Report.benchmarkVersion + "_Actual_Results_for_" + actual.getTool().replace( ' ', '_' )
					+ ".csv");
			FileOutputStream fos = new FileOutputStream(resultsFile, false);
			ps = new PrintStream(fos);
	
			// Write actual results header
			ps.print("# test name, category, real vulnerability, CWE, identified by tool, pass/fail");

			// Add the version # inside the file as well
			ps.print(", Benchmark version: " + Report.benchmarkVersion);
			
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
	
	/**
	 * This method updates the menus of all the scorecards previously generated so people can navigate
	 * between all the tool results.
	 */
	static void updateMenus(List<Report> toolResults) {
		
	/*
	 * The menus when constructed by hand look like this:
	 *       <li><a href="OWASP_Benchmark_for_Fortify.html">Fortify</a></li>
     *       <li><a href="OWASP_Benchmark_for_PMD.html">PMD</a></li>
     *       etc.
     *       
     *       The following computes the new menus.
	 */
		StringBuffer sb = new StringBuffer();
		// Go through each of the scorecard files and create the menu required for all the files
		for (int i = 0; i < toolResults.size(); i++) {
			Report toolReport = toolResults.get(i);
			sb.append("            <li><a href=\"");
			sb.append(toolReport.getFilename());
			sb.append(".html\">");
			sb.append(toolReport.getToolName());
			sb.append("</a></li>");
			sb.append(System.lineSeparator());
		}
		
		// We then replace each of the menu placeholders in all the computed scorecards with the computed menu.
		String menu = sb.toString();
		
		try {
			
			for (int i = 0; i < toolResults.size(); i++) {
				toolResults.get(i).updateMenus(menu);
			}
			
	    	// We also have to update the menus in the Home and Guide pages and then copy those
	    	// files to where they need to go
	    	
			// Then copy the static HOME and GUIDE HTML files, that were also deleted
	        String homeHtml = new String(Files.readAllBytes(Paths.get(Report.pathToScorecardResources + HOMEFILENAME)));
	        homeHtml = homeHtml.replace("${menu}", menu);
	        homeHtml = homeHtml.replace( "${version}", Report.benchmarkVersion );
	        Files.write(Paths.get( Report.scoreCardDirName + "/" + HOMEFILENAME), homeHtml.getBytes());
	        
	        String guideHtml = new String(Files.readAllBytes(Paths.get(Report.pathToScorecardResources + GUIDEFILENAME)));
	        guideHtml = guideHtml.replace("${menu}", menu);
	        guideHtml = guideHtml.replace( "${version}", Report.benchmarkVersion );
	        Files.write(Paths.get( Report.scoreCardDirName + "/" + GUIDEFILENAME), guideHtml.getBytes());
	        
	        // And then generate the comparison chart for the test of tools in this test
            ScatterScores.generateComparisonChart(toolResults);
            
            // And generate comparison of vulnerabilities
            HashSet<String> catSet = new HashSet<String>();
            for ( int i= 0; i < toolResults.size(); i++ ) {
                Report toolReport = toolResults.get(i);
                catSet.addAll( toolReport.getOverallResults().getCategories() );
            }
            for ( String cat : catSet ) {
                ScatterVulns.generateComparisonChart(cat, toolResults);
            }
	        
		} catch (IOException e) {
	    	System.out.println("Error!! - couldn't update scorecard file");
	    	e.printStackTrace();
	    }
	}
}
