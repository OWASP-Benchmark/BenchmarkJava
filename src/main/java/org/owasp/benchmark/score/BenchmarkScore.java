/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers
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
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.owasp.benchmark.helpers.Utils;
import org.owasp.benchmark.score.parsers.AcunetixReader;
import org.owasp.benchmark.score.parsers.AppScanDynamicReader;
import org.owasp.benchmark.score.parsers.AppScanDynamicReader2;
import org.owasp.benchmark.score.parsers.AppScanSourceReader;
import org.owasp.benchmark.score.parsers.AppScanSourceReader2;
import org.owasp.benchmark.score.parsers.ArachniReader;
import org.owasp.benchmark.score.parsers.BurpJsonReader;
import org.owasp.benchmark.score.parsers.BurpReader;
import org.owasp.benchmark.score.parsers.CASTAIPReader;
import org.owasp.benchmark.score.parsers.CheckmarxESReader;
import org.owasp.benchmark.score.parsers.CheckmarxIASTReader;
import org.owasp.benchmark.score.parsers.CheckmarxReader;
import org.owasp.benchmark.score.parsers.ContrastReader;
import org.owasp.benchmark.score.parsers.Counter;
import org.owasp.benchmark.score.parsers.CoverityReader;
import org.owasp.benchmark.score.parsers.CrashtestReader;
import org.owasp.benchmark.score.parsers.FaastReader;
import org.owasp.benchmark.score.parsers.FindbugsReader;
import org.owasp.benchmark.score.parsers.FortifyReader;
import org.owasp.benchmark.score.parsers.FusionLiteInsightReader;
import org.owasp.benchmark.score.parsers.HCLReader;
import org.owasp.benchmark.score.parsers.HdivReader;
import org.owasp.benchmark.score.parsers.JuliaReader;
import org.owasp.benchmark.score.parsers.KiuwanReader;
import org.owasp.benchmark.score.parsers.LGTMReader;
import org.owasp.benchmark.score.parsers.CodeQLReader;
import org.owasp.benchmark.score.parsers.NetsparkerReader;
import org.owasp.benchmark.score.parsers.NoisyCricketReader;
import org.owasp.benchmark.score.parsers.OverallResult;
import org.owasp.benchmark.score.parsers.OverallResults;
import org.owasp.benchmark.score.parsers.ParasoftReader;
import org.owasp.benchmark.score.parsers.PMDReader;
import org.owasp.benchmark.score.parsers.QualysWASReader;
import org.owasp.benchmark.score.parsers.Rapid7Reader;
import org.owasp.benchmark.score.parsers.Reader;
import org.owasp.benchmark.score.parsers.SeekerReader;
import org.owasp.benchmark.score.parsers.SemgrepReader;
import org.owasp.benchmark.score.parsers.ShiftLeftReader;
import org.owasp.benchmark.score.parsers.SnappyTickReader;
import org.owasp.benchmark.score.parsers.SonarQubeJsonReader;
import org.owasp.benchmark.score.parsers.SonarQubeReader;
import org.owasp.benchmark.score.parsers.SourceMeterReader;
import org.owasp.benchmark.score.parsers.TestCaseResult;
import org.owasp.benchmark.score.parsers.TestResults;
import org.owasp.benchmark.score.parsers.ThunderScanReader;
import org.owasp.benchmark.score.parsers.VeracodeReader;
import org.owasp.benchmark.score.parsers.VisualCodeGrepperReader;
import org.owasp.benchmark.score.parsers.WapitiReader;
import org.owasp.benchmark.score.parsers.WebInspectReader;
import org.owasp.benchmark.score.parsers.XanitizerReader;
import org.owasp.benchmark.score.parsers.ZapReader;
import org.owasp.benchmark.score.report.Report;
import org.owasp.benchmark.score.report.ScatterHome;
import org.owasp.benchmark.score.report.ScatterVulns;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class BenchmarkScore {

	// This value is pulled from the expected results file being processed
	public static String TESTSUITEVERSION;

	// TODO: Make next 3 configurable values (via command line or expected results file when invoking scorecard generation)
	// Prefixes for generated test suites and file names. Used by lots of other classes for scorecard generation.
	public static final String TESTSUITE = "Benchmark";
	public static final String TEST = "Test";
	public static final String TESTCASENAME = TESTSUITE + TEST;

	// The # of numbers in a test case name. Must match what is actually generated.
	public static final int TESTIDLENGTH = 5;

	// TODO: Move to static initializer so these filenames can be changed during startup
	private static final String GUIDEFILENAME = "OWASP_Benchmark_Guide.html";
	private static final String HOMEFILENAME = "OWASP_Benchmark_Home.html";
	public static final String PATHTOSCORECARDRESOURCES = Utils.RESOURCES_DIR + "scorecard" + File.separator;
	// scorecard dir normally created under current user directory
	public static final String scoreCardDirName = "scorecard";

	private static final String TESTSUITE_VERSION_PREFIX = BenchmarkScore.TESTSUITE + " version: ";

	// This is used to indicate that results from multiple versions of the Benchmark are included in these results.
	// Each set in their own directory with their associated expectedresults file.
	public static boolean mixedMode = false;
	// Indicates that the names of Commercial tools should be anonymized
	public static boolean anonymousMode = false;
	// Indicates that the results of Commercial tools should be suppressed. Only show their averages.
	public static boolean showAveOnlyMode = false;
	// The name of this file if generated
	private static String commercialAveScorecardFilename = null;
	// The name of the tool to 'focus' on, if any
	private static String focus = "none";

	/*
	 * A list of the reports produced for each tool.
	 */
	private static Set<Report> toolResults = new TreeSet<Report>();

	private static final String usageNotice = "Usage: BenchmarkScore expected actual (optional) toolname anonymous/show_ave_only\n"
		+ "  expected - path of expected results file from Benchmark distribution.\n"
		+ "    Use value: 'mixed' if there are multiple results subdirectories for different versions of the Benchmark.\n"
		+ "  actual   - results file, or directory with result files from tools (.ozasmt, .fpr, .fvdl, .xml, etc...\n"
		+ "    For 'mixed' mode, this is the root directory that contains subdirectories with results files.\n"
		+ "  An optional 3rd parameter - Name of tool to focus on, or 'none'. This highlights that particular tool in the"
		+ "    generated charts."
		+ "  And two optional 4th parameters - can only use one or the other"
		+ "    anonymous - tells the scorecard generator to hide the names of commercial tools.\n"
		+ "    show_ave_only - tells the scorecard generator to hide the commercial tool results"
		+ "      entirely, and only show the commercial average.\n";

	public static void main(String[] args) {
		if ( args == null || args.length < 2 ) {
			System.out.println( usageNotice );
			System.exit( -1 );
		}

	if ( args.length > 2 ) {
		focus = args[2].replace(' ','_');
	}

	if (args.length > 3) {
		if ("anonymous".equalsIgnoreCase(args[3])) {
			anonymousMode = true;
		} else if ("show_ave_only".equalsIgnoreCase(args[3])) {
			showAveOnlyMode = true;
		} else {
			System.out.println( usageNotice );
			System.exit( -1 );
		}
	}

	// Prepare the scorecard results directory for the newly generated scorecards
	// Step 1: Create the dir if it doesn't exist, or delete everything in it if it does
	File scoreCardDir = new File(scoreCardDirName);
	try {
		if (!scoreCardDir.exists()) {
			Files.createDirectories(Paths.get(scoreCardDirName));
		} else {
			System.out.println("Deleting previously generated scorecard files in: " + scoreCardDir.getAbsolutePath());
			FileUtils.cleanDirectory(scoreCardDir);
		}

		// Step 2: Now copy the entire /content directory, that either didn't exist, or was just deleted with everything else
		File dest1 = new File(scoreCardDirName + File.separator + "content");
		FileUtils.copyDirectory(new File(PATHTOSCORECARDRESOURCES + "content"), dest1);

	} catch (IOException e) {
		System.out.println("Error dealing with scorecard directory: '" + scoreCardDir.getAbsolutePath() + "' for some reason!");
		e.printStackTrace();
	}

	// Step 3: Copy over the Homepage and Guide templates
	try {
		Files.copy(Paths.get(PATHTOSCORECARDRESOURCES + HOMEFILENAME),
			Paths.get( scoreCardDirName + "/" + HOMEFILENAME),
			StandardCopyOption.REPLACE_EXISTING );

		Files.copy(Paths.get(PATHTOSCORECARDRESOURCES + GUIDEFILENAME),
			Paths.get( scoreCardDirName + "/" + GUIDEFILENAME),
			StandardCopyOption.REPLACE_EXISTING );
	} catch( IOException e ) {
		System.out.println( "Problem copying home and guide files" );
		e.printStackTrace();
	}

	// Steps 4 & 5: Read the expected results so we know what each tool 'should do' and the each results file. a) is for 'mixed' mode, and b) is for normal mode
	try {

		if ("mixed".equalsIgnoreCase(args[0])) {

			mixedMode = true; // Tells anyone that cares that we aren't processing a single version of Benchmark results

			File f = new File( args[1] );
			if (!f.exists()) {
				System.out.println( "Error! - results directory: '" + f.getAbsolutePath() + "' doesn't exist.");
				System.exit(-1);
			}
			if ( !f.isDirectory() ) {
				System.out.println( "Error! - results parameter is a file: '" + f.getAbsolutePath()
					+ "' but must be a directory when processing results in 'mixed' mode.");
				System.exit(-1);
			}

			// Go through each file in the root directory.
			// -- 1st find each directory. And then within each of those directories:
			//    -- 1st find the expected results file in that directory
			//    -- and then each of the actual results files in that directory

			for ( File rootDirFile : f.listFiles() ) {

				if (rootDirFile.isDirectory()) {

					// Process this directory
					TestResults expectedResults = null;
					String expectedResultsFilename = null;

				// Step 4a: Find and process the expected results file so we know what each tool in this directory 'should do'
					for ( File resultsDirFile : rootDirFile.listFiles() ) {

					if (resultsDirFile.getName().startsWith("expectedresults-")) {
						if (expectedResults != null) {
							System.out.println( "Found 2nd expected results file " + resultsDirFile.getAbsolutePath()
								+ " in same directory. Can only have 1 in each results directory");
							System.exit(-1);
						}

						// read in the expected results for this directory of results
						expectedResults = readExpectedResults( resultsDirFile );
						System.out.println("Getting expected results from: " + resultsDirFile);
						if (expectedResults == null) {
							System.out.println( "Couldn't read expected results file: "
									+ resultsDirFile.getAbsolutePath());
							System.exit(-1);
						} // end if

						expectedResultsFilename = resultsDirFile.getName();
						if (TESTSUITEVERSION == null) {
							TESTSUITEVERSION = expectedResults.getTestSuiteVersion();
						} else TESTSUITEVERSION += "," + expectedResults.getTestSuiteVersion();
						System.out.println("\nFound expected results file: " + resultsDirFile.getAbsolutePath());
					} // end if
				} // end for loop going through each directory looking for expected results file

				// Make sure we found an expected results file, before processing the results
				if (expectedResults == null) {
					System.out.println( "Couldn't find expected results file in results directory: "
						+ rootDirFile.getAbsolutePath());
					System.out.println( "Expected results file has to be a .csv file that starts with: 'expectedresults-'");
					System.exit(-1);
				}

				// Step 5a: Go through each result file and generate a scorecard for that tool.
				if (!anonymousMode) {
					for ( File actual : rootDirFile.listFiles() ) {
						// Don't confuse the expected results file as an actual results file if its in the same directory
						if (!actual.isDirectory() && !expectedResultsFilename.equals(actual.getName())) {
							process( actual, expectedResults, toolResults);
						}
					} // end for
				} else {
					// To handle anonymous mode, we are going to randomly grab files out of this directory
					// and process them. By doing it this way, multiple runs should randomly order the commercial
					// tools each time.
					List<File> files = new ArrayList<File>();
					for ( File file : rootDirFile.listFiles() ) {
						files.add(file);
					}

					SecureRandom generator = SecureRandom.getInstance("SHA1PRNG");
					while (files.size() > 0) {
						// Get a random, positive integer
						int fileToGet = Math.abs(generator.nextInt(files.size()));
						File actual = files.remove(fileToGet);
						// Don't confuse the expected results file as an actual results file if its in the same directory
						if (!actual.isDirectory() && !expectedResultsFilename.equals(actual.getName())) {
							process( actual, expectedResults, toolResults);
						}
					} // end while
				} // end else
			} // end if a directory
		} // end for loop through all files in the directory

		// process the results the normal way with a single results directory
		} else { // Not "mixed"

			// Step 4b: Read the expected results so we know what each tool 'should do'
			File expected = new File( args[0] );
			System.out.println("Getting expected results from: " + args[0]);
			TestResults expectedResults = readExpectedResults( expected );
			if (expectedResults == null) {
				System.out.println( "Couldn't read expected results file: " + expected);
				System.exit(-1);
			} else {
				System.out.println( "Read expected results from file: " + expected.getAbsolutePath());
				int totalResults = expectedResults.getTotalResults();
				if (totalResults != 0) {
					System.out.println( totalResults + " results found.");
					TESTSUITEVERSION = expectedResults.getTestSuiteVersion();
				} else {
					System.out.println( "Error! - zero expected results found in results file.");
					System.exit(-1);
				}
			}

			// Step 5b: Go through each result file and generate a scorecard for that tool.
			File f = new File( args[1] );
			if (!f.exists()) {
				System.out.println( "Error! - results file: '" + f.getAbsolutePath() + "' doesn't exist.");
				System.exit(-1);
			}
			if ( f.isDirectory() ) {
				if (!anonymousMode) {
					for ( File actual : f.listFiles() ) {
						// Don't confuse the expected results file as an actual results file if its in the same directory
						if (!actual.isDirectory() && !expected.getName().equals(actual.getName())) {
							process( actual, expectedResults, toolResults);
						}
					} // end for
				} else {
					// To handle anonymous mode, we are going to randomly grab files out of this directory
					// and process them. By doing it this way, multiple runs should randomly order the commercial
					// tools each time.
					List<File> files = new ArrayList<File>();
					for ( File file : f.listFiles() ) {
						files.add(file);
					}

					SecureRandom generator = SecureRandom.getInstance("SHA1PRNG");
					while (files.size() > 0) {
						int randomNum = generator.nextInt();
						// FIXME: Get Absolute Value better
						if (randomNum < 0) randomNum *= -1;
						int fileToGet = randomNum % files.size();
						File actual = files.remove(fileToGet);
						// Don't confuse the expected results file as an actual results file if its in the same directory
						if (!actual.isDirectory() && !expected.getName().equals(actual.getName())) {
							process( actual, expectedResults, toolResults);
						}
					} // end while
				} // end else (!anonymousMode)

			} else {
				// This will process a single results file, if that is what the 2nd parameter points to.
				// This has never been used.
				process( f, expectedResults, toolResults );
			} // end else ( f.isDirectory() )
		} // end else "Not mixed"

		System.out.println( "Tool scorecards computed." );

	// catch try for Steps 4 & 5
	} catch( Exception e ) {
		System.out.println( "Error during processing: " + e.getMessage() );
		e.printStackTrace();
	}

	// Step 6: Now generate scorecards for each type of vulnerability across all the tools

	// First, we have to figure out the list of vulnerabilities
	// A set is used here to eliminate duplicate categories across all the results
	Set<String> catSet = new TreeSet<String>();
	for ( Report toolReport : toolResults ) {
		catSet.addAll( toolReport.getOverallResults().getCategories() );
	}

	// Then we generate each vulnerability scorecard
	BenchmarkScore.generateVulnerabilityScorecards(toolResults, catSet );
	System.out.println( "Vulnerability scorecards computed." );

	// Step 7: Update all the menus for all the generated pages to reflect the tools and vulnerability categories
	updateMenus(toolResults, catSet);

	// Step 8: Generate the overall comparison chart for all the tools in this test
	ScatterHome.generateComparisonChart(toolResults, focus);

	// Step 9: Generate the results table across all the tools in this test
	String table = generateOverallStatsTable(toolResults);

	File f = Paths.get( scoreCardDirName + "/" + HOMEFILENAME).toFile();
	try {
		String html = new String( Files.readAllBytes( f.toPath() ) );
		html = html.replace("${table}", table);
		Files.write( f.toPath(), html.getBytes() );
	} catch ( IOException e ) {
		System.out.println ( "Error updating results table in: " + f.getName() );
		e.printStackTrace();
	}

	System.out.println( BenchmarkScore.TESTSUITE + " scorecards complete." );

	System.exit(0);
}

	/**
	 * The method takes in a tool scan results file and determined how well that tool did against the test suite.
	 * @param f - The results file to process. This is the native results file from the tool.
	 * @param expectedResults - This is the expected results csv file for this version of the test suite.
	 * @param toolResults - This list contains some information about the results for each tool. It is updated
	 * in this method so that the menus across all the scorecards can be generated and a summary scorecard can be
	 * computed. A new entry is added each time this method is called which adds the name of the tool, the filename of the
	 * scorecard, and the report that was created for that tool.
	 */
	private static void process(File f, TestResults expectedResults, Set<Report> toolreports) {

          try {
            // Figure out the actual results for this tool from the raw results file for this tool
            System.out.println( "\nAnalyzing results from " + f.getName() );
            TestResults actualResults = readActualResults( f );
            //System.out.println("Computed actual results for tool: " + actualResults.getTool());

            if ( expectedResults != null && actualResults != null ) {
                // note: side effect is that "pass/fail" value is set for each expected result so it
            	// can be used to produce scorecard for this tool
                analyze( expectedResults, actualResults );

                // Produce a .csv results file of the actual results, except if its a commercial tool,
                // and we are in showAveOnly mode.
                String actualResultsFileName = "notProduced";
                if (!(showAveOnlyMode && actualResults.isCommercial)) {
                	actualResultsFileName = produceResultsFile (expectedResults);
                }

                Map<String,Counter> scores = calculateScores( expectedResults );

                OverallResults results = calculateResults( scores );
                results.setTime( actualResults.getTime() );

                // This has the side effect of also generating the report on disk.
                Report scoreCard = new Report( actualResults, scores, results, expectedResults.getTotalResults(),
                		actualResultsFileName, actualResults.isCommercial(),actualResults.getToolType());

                // Add this report to the list of reports
                toolreports.add(scoreCard);

                // This is for debugging purposes. It indicates how may extra results were found in the
                // actual results vice the expected results.
                // printExtraCWE( expectedResults, actualResults );
            } else {
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
    @SuppressWarnings("unused")
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
       int total = 0;
       int totalTP = 0;
       int totalFP = 0;
       int totalFN = 0;
       int totalTN = 0;
       for ( String category : results.keySet() ) {
          Counter c = results.get( category );
          int rowTotal = c.tp + c.fn + c.tn + c.fp;
          double tpr = (double) c.tp / (double) ( c.tp + c.fn );
          double fpr = (double) c.fp / (double) ( c.fp + c.tn );
//        double fdr = c.fp / ( c.tp + c.fp );

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
          total += rowTotal;
          totalTP += c.tp;
          totalFP += c.fp;
          totalFN += c.fn;
          totalTN += c.tn;

          or.add( category, tpr, fpr, rowTotal, score );
      } // end for

      int resultsSize = results.size();
      or.setScore( totalScore / resultsSize );
      or.setFalsePositiveRate( totalFPRate / resultsSize );
      or.setTruePositiveRate( totalTPRate / resultsSize );
      or.setTotal(total);
      or.setFindingCounts(totalTP, totalFP, totalFN, totalTN);

      return or;
   }

    /**
     * This method translates vulnerability categories, e.g., xss, to their long names for human consumption.
     * @param The category to translate.
     * @return The human readable value of that category.
     */
	public static String translateCategoryToName(String category) {
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
			case "hqli" : return "Hibernate Injection";
			case "trustbound" : return "Trust Boundary Violation";
			case "xpathi" : return "XPath Injection";
			default : return "Unknown Vulnerability: " + category;
		}
	}

    /**
     * This method translates vulnerability categories, e.g., xss, to their CWE number.
     * @param The category to translate.
     * @return The CWE # of that category.
     */
	public static int translateCategoryToCWE(String category) {
		switch( category ) {
			case "cmdi" : return 78;
			case "xss" : return 79;
			case "ldapi" : return 90;
			case "securecookie" : return 614;
			case "pathtraver" : return 22;
			case "crypto" : return 327;
			case "hash" : return 328;
			case "weakrand" : return 330;
			case "sqli" : return 89;
			case "hqli" : return 564; // This is the real CWE for Hibernate Injection, but most tools probably report 89
			case "trustbound" : return 501;
			case "xpathi" : return 643;
			default : return 0;
		}
	}

    /**
     * This method translates vulnerability names, e.g., Cross-Site Scripting, to their CWE number.
     * @param The category to translate.
     * @return The CWE # of that category.
     */
	public static int translateNameToCWE(String category) {
		switch( category ) {
		case "Command Injection" : return 78;
		case "Cross-Site Scripting" : return 79;
		case "LDAP Injection" : return 90;
		case "Insecure Cookie" : return 614;
		case "Path Traversal" : return 22;
		case "Weak Encryption Algorithm" : return 327;
		case "Weak Hash Algorithm" : return 328;
		case "Weak Random Number" : return 330;
		case "SQL Injection" : return 89;
		case "Hibernate Injection" : return 564; // This is the real CWE for Hibernate Injection, but most tools probably report 89
		case "Trust Boundary Violation" : return 501;
		case "XPath Injection" : return 643;
		default :
			System.out.println("Error: Category: " + category + " not supported.");
			return -1;
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
			String cat = translateCategoryToName( tcr.getCategory() );

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


	private static TestResults readActualResults(File fileToParse) throws Exception {
		String filename = fileToParse.getName();
		TestResults tr = null;

		if ( filename.endsWith( ".csv" ) ) {
			String line1 = getLine( fileToParse, 0 );
			if ( line1.contains("CheckerKey") && line1.contains("LastDetectionURL") ) {
				tr = new SeekerReader().parse(fileToParse);
			} else if ( line1.contains("CWE") && line1.contains("URL") ) {		
				tr = new CheckmarxIASTReader().parse(fileToParse);
			} else System.out.println("Error: No matching parser found for CSV file: " + filename);
		}

		else if ( filename.endsWith( ".ozasmt" ) ) {
			tr = new AppScanSourceReader().parse( fileToParse );
		}
        
		else if ( filename.endsWith( ".faast" ) ) {
			tr = new FaastReader().parse( fileToParse );
		}

        else if ( filename.endsWith( ".json" ) ) {

            String line2 = getLine( fileToParse, 1 );
            if ( line2 != null && (line2.contains("Coverity") || line2.contains("formatVersion")) ) {
                tr = new CoverityReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.contains("Vendor") && line2.contains("Checkmarx") ) {
                tr = new CheckmarxESReader().parse( fileToParse );
            }

            else { // Handle JSON where we have to look for a specific node to identify the tool type

				String content = new String(Files.readAllBytes(Paths.get(fileToParse.getPath())));
				JSONObject jsonobj = new JSONObject(content);

				try {
					jsonobj.getJSONArray("results"); // Throws JSONException if this Node not found.
					tr = new SemgrepReader().parse( jsonobj );
				} catch (JSONException e) {

				// Note: Each of the remaining try blocks is nested under the one above, but we shown them
				// inline as they would get too deep otherwise
				try {
					// SonarQube has two different JSON formats, one for standard issues and
					// another for 'hotspots' which are securit issues. Both are handled by the same
					// parser for SonarQube.
					jsonobj.getJSONArray("issues");
					tr = new SonarQubeJsonReader().parse( fileToParse );
				} catch (JSONException e2) {

				try {
					jsonobj.getJSONArray("hotspots");
					tr = new SonarQubeJsonReader().parse( fileToParse );
				} catch (JSONException e3) {

				try {
					jsonobj.getJSONArray("issue_events");
					tr = new BurpJsonReader().parse( fileToParse );

					// This is the final catch that says we couldn't find a matching parser
						} catch (JSONException e4) {
							System.out.println("Error: No matching parser found for JSON file: " + filename);
						}

						} // end catch SonarQubeJsonReader - hotspots
					} // end catch SonarQubeJsonReader - issues
				} // end catch SemgrepReader
            }
        }

		else if ( filename.endsWith( ".sarif" ) ) {
			// CodeQL results and LGTM results both have the same extension .sarif
			// But only the LGTM results have "semmle.sourceLanguage" as a key in ["run.properties"]
			String content = new String(Files.readAllBytes(Paths.get(fileToParse.getPath())));
			JSONObject jsonobj = new JSONObject(content);
			JSONArray runs = jsonobj.getJSONArray("runs");

			try{
				for (int i = 0; i < runs.length(); i++){
					JSONObject run = runs.getJSONObject(i);
					JSONObject properties = run.getJSONObject("properties");
					properties.getString("semmle.sourceLanguage");
				}
				tr = new LGTMReader().parse( fileToParse ); // If "semmle.sourceLanguage" is available set the LGTMReader
			} catch (JSONException e){
				tr = new CodeQLReader().parse( fileToParse ); // If "semmle.sourceLanguage" is not available set the CodeQLReader
			}
		}

        else if ( filename.endsWith( ".threadfix" ) ) {
            tr = new KiuwanReader().parse( fileToParse );
        }

        else if ( filename.endsWith( ".txt" ) ) {
            String line1 = getLine( fileToParse, 0 );
            if ( line1.startsWith( "Possible " ) ) {
                tr = new SourceMeterReader().parse( fileToParse );
            }
        }

        else if ( filename.endsWith( ".xml" ) ) {

            // Handle XML results files where the 1st or 2nd line indicates the tool type

            String line1 = getLine( fileToParse, 0 ); // line1 is frequently like: <?xml version="1.0"?>
            String line2 = getLine( fileToParse, 1 );
            String line4;

            if ( line2 != null && line2.startsWith( "  <ProjectName>" )) {
                tr = new ThunderScanReader().parse(fileToParse);
            }

            else if ( line2 != null && line2.startsWith( "<pmd" )) {
                tr = new PMDReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.toLowerCase().startsWith( "<castaip" ) ) {
                tr = new CASTAIPReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.startsWith( "<FusionLiteInsight" )) {
                tr = new FusionLiteInsightReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.startsWith( "<XanitizerFindingsList" )) {
                tr = new XanitizerReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.startsWith( "<BugCollection" )) {
                tr = new FindbugsReader().parse( fileToParse );

                // change the name of the tool if the filename contains findsecbugs
                if (fileToParse.getName().contains("findsecbugs")) {
                    if (tr.getTool().startsWith("Find")) {
                        tr.setTool("FBwFindSecBugs");
                    } else {
                        tr.setTool("SBwFindSecBugs");
                    }
                }
            }

            else if ( line2 != null && line2.startsWith( "<ResultsSession" )) {
                tr = new ParasoftReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.startsWith( "<detailedreport" )) {
                tr = new VeracodeReader().parse( fileToParse );
            }

            else if ( line1.startsWith( "<testsuites name=\"" ) ) {
                tr = new CrashtestReader().parse( fileToParse );
            }

            else if ( line1.startsWith( "<total" ) || line1.startsWith( "<p>" )) {
                tr = new SonarQubeReader().parse( fileToParse );
            }

            else if ( line1.contains( "<OWASPZAPReport" ) ||
                      ( line2 != null && line2.contains( "<OWASPZAPReport" )) ) {
                tr = new ZapReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.startsWith( "<CxXMLResults" )) {
                tr = new CheckmarxReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.contains( "Arachni" )) {
                tr = new ArachniReader().parse( fileToParse );
            }

            else if ( line2 != null && (line2.startsWith( "<analysisResult") ||
                        line2.startsWith( "<analysisReportResult"))) {
                tr = new JuliaReader().parse( fileToParse );
            }

            else if ( line2 != null && line2.startsWith( "<CodeIssueCollection") ) {
                tr = new VisualCodeGrepperReader().parse( fileToParse );
            }

            else if ( (line4 = getLine( fileToParse, 4 )) != null && line4.contains( "Wapiti" )) {
                tr = new WapitiReader().parse( fileToParse );
            }

            else { // Handle XML where we have to look for a specific node to identify the tool type

                Document doc = getXMLDocument( fileToParse );
                Node root = doc.getDocumentElement();
                String nodeName = root.getNodeName();

                if ( nodeName.equals( "ScanGroup" ) || nodeName.equals( "acunetix-360" )) {
                    tr = new AcunetixReader().parse( root );
                }

                else if ( nodeName.equals( "XmlReport" ) ) {
                    tr = new AppScanDynamicReader().parse( root );
                }

                else if ( nodeName.equals( "xml-report" ) ) {
                    // For Appscan, this node has name="AppScan Report" and technology="SAST" or "DAST"
                    String name = Reader.getAttributeValue( "name", root );
                    if ("AppScan Report".equals(name)) {
                        String tech = Reader.getAttributeValue( "technology", root );
                        if ("SAST".equals(tech)) {
                            tr = new AppScanSourceReader2().parse( fileToParse );
                        } else if ("DAST".equals(tech)) {
                            tr = new AppScanDynamicReader2().parse( fileToParse );
                        } else System.out.println("Found AppScan Report with unfamiliar technology type: " + tech);
                    } else System.out.println("Found xml-report that was expected to have a name 'AppScan Report "
                                + " but had name: " + name);
                }

                else if ( nodeName.equals( "issues" ) ) {
                    tr = new BurpReader().parse( fileToParse, root );
                }

                else if ( nodeName.equals( "netsparker" ) ) {
                    tr = new NetsparkerReader().parse( root );
                }

                else if ( nodeName.equals( "noisycricket" ) ) {
                    tr = new NoisyCricketReader().parse( root );
                }

                else if ( nodeName.equals( "VulnSummary" ) ) {
                    tr = new Rapid7Reader().parse( root );
                }

                else if ( nodeName.equals( "Report" ) ) {
                    tr = new SnappyTickReader().parse( root );
                }

                else if ( nodeName.equals( "Scan" ) ) {
                    tr = new WebInspectReader().parse( root );
                }

                else if ( nodeName.equals( "WAS_SCAN_REPORT" ) ) {
                    tr = new QualysWASReader().parse( fileToParse, root );
                }

                else System.out.println("Error: No matching parser found for XML file: " + filename);

            } // end else
         } // end if endsWith ".xml"

		else if ( filename.endsWith( ".fpr" ) ) {

		// .fpr files are really .zip files. So we have to extract the .fvdl file out of it to process it
		    Path path = Paths.get(fileToParse.getPath());
		    FileSystem fileSystem = FileSystems.newFileSystem(path, (java.lang.ClassLoader) null);
		    File outputFile = File.createTempFile( filename, ".fvdl");
		    Path source = fileSystem.getPath("audit.fvdl");
		    Files.copy(source, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    tr = FortifyReader.parse( outputFile );
		    outputFile.delete();

		    // Check to see if the results are regular Fortify or Fortify OnDemand results
		    // To check, you have to look at the filtertemplate.xml file inside the .fpr archive
		    // and see if that file contains: "Fortify-FOD-Template"
		    outputFile = File.createTempFile( filename + "-filtertemplate", ".xml");
		    source = fileSystem.getPath("filtertemplate.xml");

		    // In older versions of Fortify, like 4.1, the filtertemplate.xml file doesn't exist
		    // So only check it if it exists
			try {
			    Files.copy(source, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			    BufferedReader br = new BufferedReader(new FileReader(outputFile));
			    try {
			        StringBuilder sb = new StringBuilder();
			        String line = br.readLine();

			        // Only read the first 3 lines and the answer is near the top of the file.
			        int i = 1;
			        while (line != null && i++ <= 3) {
			            sb.append(line);
			            line = br.readLine();
			        }
			        if ( sb.indexOf("Fortify-FOD-") > -1 ) {
			        	tr.setTool( tr.getTool() + "-OnDemand" );
			        }
			    } finally {
			        br.close();
			    }
			} catch (NoSuchFileException e) {
				// Do nothing if the filtertemplate.xml file doesn't exist in the .fpr archive
			} finally {
				outputFile.delete();
			}
		}

        else if ( filename.endsWith( ".log" ) ) {
            tr = new ContrastReader().parse( fileToParse );
        }

        else if ( filename.endsWith( ".hcl" ) ) {
            tr = new HCLReader().parse( fileToParse );
        }

        else if ( filename.endsWith( ".hlg" ) ) {
            tr = new HdivReader().parse( fileToParse );
        }

        else if ( filename.endsWith( ".sl" ) ) {
            tr = new ShiftLeftReader().parse( fileToParse );
        }

        else System.out.println("Error: No matching parser found for file: " + filename);

		// If we have results, see if the version # is in the results file name.
		if (tr != null) {
			// If version # specified in the results file name, extract it, and set it.
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
		}

		return tr;
	}

	/**
	 * Read the specified line of the provided file. If its blank, skip all blank lines until a non-blank
	 * line is found and return that. Return "" if no non-blank line is found from the specified line on.
	 * @return The first non-blank line in the file starting with the specified line. null if there aren't
	 * that many lines in the file.
	 */
	private static String getLine(File actual, int lineNum) {

		try (BufferedReader br = new BufferedReader( new FileReader( actual )) ) {
			// Skip all the lines before the line # requested
			String line = null;
		    for ( int i=0; i<=lineNum; i++ ) {
				line = br.readLine();
    		}
		    while ( "".equals( line )) {
		    	line = br.readLine();
		    }
		    return line;
		} catch( IOException e ) {
			return "";
		}
	}

	/**
	 * Read through the provided file and return true if it contains the specified string.
	 * @return True if string found. False otherwise
	 */
	private static boolean fileContains(File actual, String value) {

		try (BufferedReader br = new BufferedReader( new FileReader( actual )) ) {
			String line;
			do {
				line = br.readLine();
				if (line == null) return false;
				if (line.contains(value)) return true;
			} while (line != null);
		} catch( IOException e ) {
			// Do nothing
		}
		return false;
	}

    // Go through each expected result, and figure out if this tool actually passed or not.
    // This updates the expected results to reflect what passed/failed.
    private static void analyze( TestResults expected, TestResults actual ) {

    	// Set the version of the test suite these actual results are being compared against
    	actual.setTestSuiteVersion(expected.getTestSuiteVersion());

    	// If in anonymous mode, anonymize the tool name if its a commercial tool before its used to compute anything.
	    // unless its the tool of 'focus'
		if (BenchmarkScore.anonymousMode && actual.isCommercial && !actual.getTool().replace(' ','_').equalsIgnoreCase(focus)) {
			actual.setAnonymous();
		}

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
		// return true if there are no actual results and this was a false positive test
		if ( actList == null || actList.isEmpty() ) {
			return !exp.isReal();
		}

		// otherwise check actual results
		for ( TestCaseResult act : actList ) {
			// Helpful in debugging
		    //System.out.println( "  Evidence: " + act.getCWE() + " " + act.getEvidence() + "[" + act.getConfidence() + "]");

			int actualCWE = act.getCWE();
			int expectedCWE = exp.getCWE();

		    boolean match = actualCWE == expectedCWE;

		    // Special case: many tools report CWE 89 (sqli) for Hibernate Injection (hqli) rather than
		    // actual CWE of 564 So we accept either
		    if (!match && (expectedCWE == 564)) {
		    	match = (actualCWE == 89);
		    }

			// special hack since IBM/Veracode don't distinguish different kinds of weak algorithm
			if ( tool.startsWith("AppScan") || tool.startsWith("Vera")) {
			    if ( expectedCWE == 328 && actualCWE == 327 ) {
			        match = true;
			    }
			}

			// return true if we find an exact match for a True Positive test
			if ( match ) {
				return exp.isReal();
			}
		}
		// if we couldn't find a match, then return true if it's a False Positive test
		return !exp.isReal();
	}

	// Create a TestResults object that contains the expected results for this version
	// of the test suite.
	private static TestResults readExpectedResults(File f1) throws Exception {
		TestResults tr = new TestResults( "Expected", true, null);
		BufferedReader fr = null;

		try {
			fr = new BufferedReader( new FileReader( f1 ) );
			// Read the 1st line, and parse out the test suite version #.
			String line = fr.readLine();
			if (line != null) {
				int startOfVersionStringLocation = line.indexOf(TESTSUITE_VERSION_PREFIX);
				if (startOfVersionStringLocation != -1) {
					startOfVersionStringLocation+=TESTSUITE_VERSION_PREFIX.length();
				} else {
					String versionNumError = "Couldn't find " + TESTSUITE_VERSION_PREFIX
							+ " on first line of expected results file";
					System.out.println(versionNumError);
					throw new IOException(versionNumError);
				}
				// Trim off everything exception the version # and everything past it.
				line = line.substring(startOfVersionStringLocation);
				int commaLocation = line.indexOf(",");
				if (commaLocation != -1) {
					tr.setTestSuiteVersion(line.substring(0, commaLocation));
				} else {
					String missingCommaError = "Couldn't find comma after version # listed after "
							+ TESTSUITE_VERSION_PREFIX;
					System.out.println(missingCommaError);
					throw new IOException(missingCommaError);
				}
			}

			boolean reading = true;
			while ( reading ) {
				line = fr.readLine();
				reading = line != null;
				if ( reading ) {
				// Normally, each line contains: test name, category, real vulnerability, cwe #

//					String[] parts = line.split(",");
// regex from http://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
					// This regex needed because some 'full details' entries contain comma's inside quoted strings
					String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
					if ( parts[0] != null && parts[0].startsWith(TESTCASENAME) ) {
						TestCaseResult tcr = new TestCaseResult();
						tcr.setTestCaseName(parts[0]);
						tcr.setCategory( parts[1]);
						tcr.setReal( Boolean.parseBoolean( parts[2] ) );
						tcr.setCWE( Integer.parseInt( parts[3]) );

						String tcname = parts[0].substring( TESTCASENAME.length() );
						tcr.setNumber( Integer.parseInt(tcname));

						// Handle situation where expected results has full details
						// Sometimes, it also has: source, data flow, data flow filename, sink

						if (parts.length > 4) {
							tcr.setSource(parts[4]);
							tcr.setDataFlow(parts[5]);
							//tcr.setDataFlowFile(parts[6]);
							tcr.setSink(parts[6]);
						}

						tr.put( tcr );
					}
				}
			}
		} finally {
			if (fr != null) fr.close();
		}
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
			String testSuiteVersion = actual.getTestSuiteVersion();
			String resultsFileName = scoreCardDirName + File.separator + TESTSUITE + "_v"
					+ testSuiteVersion + "_Scorecard_for_" + actual.getToolNameAndVersion().replace( ' ', '_' )
					+ ".csv";
			resultsFile = new File(resultsFileName);
			FileOutputStream fos = new FileOutputStream(resultsFile, false);
			ps = new PrintStream(fos);

			Set<Integer> testCaseKeys = actual.keySet();

			boolean fulldetails = (actual.get(testCaseKeys.iterator().next()).get(0).getSource() != null);

			// Write actual results header
			ps.print("# test name, category, CWE, ");
			if (fulldetails) ps.print("source, data flow, sink, ");
			ps.print("real vulnerability, identified by tool, pass/fail, " + TESTSUITE + " version: " + testSuiteVersion);

			// Append the date YYYY-MM-DD to the header in each .csv file
			Calendar c = Calendar.getInstance();
			String s = String.format("%1$tY-%1$tm-%1$te", c);
			ps.println(", Actual results generated: " + s);

			for (Integer expectedResultsKey : testCaseKeys) {
				// Write meta data to file here.
				TestCaseResult actualResult = actual.get(expectedResultsKey.intValue()).get(0);
				ps.print(actualResult.getName());
				ps.print(", " + actualResult.getCategory());
				ps.print(", " + actualResult.getCWE());
				if (fulldetails) {
					ps.print("," + actualResult.getSource());
					ps.print("," + actualResult.getDataFlow());
					ps.print("," + actualResult.getSink());
				}
				boolean isreal = actualResult.isReal();
				ps.print(", " + isreal);
				boolean passed = actualResult.isPassed();
				boolean toolresult = !(isreal^passed);
				ps.print(", " + toolresult);
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

	/*
	 * Generate all the vulnerability scorecards. And then 1 commercial tool scorecard if there are commercial tool
	 * results for at least 2 commercial tools.
	 */
	private static void generateVulnerabilityScorecards( Set<Report> toolResults, Set<String> catSet ) {
		StringBuilder htmlForCommercialAverages = null;

		int commercialToolTotal = 0;
		int numberOfVulnCategories = 0;
		int commercialLowTotal = 0;
		int commercialAveTotal = 0;
		int commercialHighTotal = 0;

        for (String cat : catSet ) {
            try {
            	ScatterVulns scatter = ScatterVulns.generateComparisonChart(cat, toolResults, focus );
                String filename = TESTSUITE + "_v" + TESTSUITEVERSION + "_Scorecard_for_" + cat.replace(' ', '_');
                Path htmlfile = Paths.get( scoreCardDirName + "/" + filename + ".html" );
                Files.copy(Paths.get(PATHTOSCORECARDRESOURCES + "vulntemplate.html" ), htmlfile, StandardCopyOption.REPLACE_EXISTING );
                String html = new String(Files.readAllBytes( htmlfile ) );
                String fullTitle = (BenchmarkScore.TESTSUITE.equals("Benchmark") ?
                   "OWASP Benchmark" : BenchmarkScore.TESTSUITE) + " Scorecard for " + cat;

                html = html.replace( "${image}", filename + ".png" );
                html = html.replace( "${title}", fullTitle );
                html = html.replace( "${vulnerability}", cat + " (CWE #"
                		+ BenchmarkScore.translateNameToCWE(cat) + ")" );
                html = html.replace( "${version}", TESTSUITEVERSION );

        		String table = generateVulnStatsTable(toolResults, cat);
        		html = html.replace( "${table}", table );

                Files.write( htmlfile, html.getBytes() );

                // Now build up the commercial stats scorecard if there are at least 2 commercial tools
                if (scatter.getCommercialToolCount() > 1) {
                	if (htmlForCommercialAverages == null) {
                		commercialToolTotal = scatter.getCommercialToolCount();
                		htmlForCommercialAverages = new StringBuilder();
                		htmlForCommercialAverages.append("<table class=\"table\">\n");
                		htmlForCommercialAverages.append("<tr>");
                		htmlForCommercialAverages.append("<th>Vulnerability Category</th>");
                		htmlForCommercialAverages.append("<th>Low Tool Type</th>");
                		htmlForCommercialAverages.append("<th>Low Score</th>");
                		htmlForCommercialAverages.append("<th>Ave Score</th>");
                		htmlForCommercialAverages.append("<th>High Score</th>");
                		htmlForCommercialAverages.append("<th>High Tool Type</th>");
                		htmlForCommercialAverages.append("</tr>\n");
                	} // if 1st time through

                	numberOfVulnCategories++;

                	String style = "";
                	htmlForCommercialAverages.append("<tr>");
                	htmlForCommercialAverages.append("<td>" + cat + "</td>");
                	htmlForCommercialAverages.append("<td>" + scatter.getCommercialLowToolType() + "</td>");
    				if (scatter.getCommercialLow() <= 10)
    					style = "class=\"danger\"";
    				else if (scatter.getCommercialLow() >= 50)
    					style = "class=\"success\"";
                	htmlForCommercialAverages.append("<td " + style + ">" + scatter.getCommercialLow() + "</td>");
                	commercialLowTotal += scatter.getCommercialLow();
                	htmlForCommercialAverages.append("<td>" + scatter.getCommercialAve() + "</td>");
                	commercialAveTotal += scatter.getCommercialAve();
    				if (scatter.getCommercialHigh() <= 10)
    					style = "class=\"danger\"";
    				else if (scatter.getCommercialHigh() >= 50)
    					style = "class=\"success\"";
    				htmlForCommercialAverages.append("<td " + style + ">" + scatter.getCommercialHigh() + "</td>");
                	commercialHighTotal += scatter.getCommercialHigh();
                	htmlForCommercialAverages.append("<td>" + scatter.getCommercialHighToolType() + "</td>");
                	htmlForCommercialAverages.append("</tr>\n");
                }  // if more than 1 commercial tool

            } catch( IOException e ) {
                System.out.println( "Error generating vulnerability summaries: " + e.getMessage() );
                e.printStackTrace();
            }
        } // end for loop

        // if we computed a commercial average, then add the last row to the table AND create the file and write the HTML to it.
        if (htmlForCommercialAverages != null) {

        	htmlForCommercialAverages.append("<tr>");
        	htmlForCommercialAverages.append("<td>Average across all categories for " + commercialToolTotal + " tools</td>");
        	htmlForCommercialAverages.append("<td></td>");
        	htmlForCommercialAverages.append("<td>"
        			+ new DecimalFormat("0.0").format((float) commercialLowTotal/(float) numberOfVulnCategories) + "</td>");
        	htmlForCommercialAverages.append("<td>"
        			+ new DecimalFormat("0.0").format((float) commercialAveTotal/(float) numberOfVulnCategories) + "</td>");
        	htmlForCommercialAverages.append("<td>"
        			+ new DecimalFormat("0.0").format((float) commercialHighTotal/(float) numberOfVulnCategories) + "</td>");
        	htmlForCommercialAverages.append("<td></td>");
        	htmlForCommercialAverages.append("</tr>\n");
        	htmlForCommercialAverages.append("</table>\n");

            try {

            	commercialAveScorecardFilename = TESTSUITE + "_v" + TESTSUITEVERSION + "_Scorecard_for_Commercial_Tools";
	            Path htmlfile = Paths.get( scoreCardDirName + "/" + commercialAveScorecardFilename + ".html" );
	            Files.copy(Paths.get(PATHTOSCORECARDRESOURCES + "commercialAveTemplate.html" ), htmlfile, StandardCopyOption.REPLACE_EXISTING );
	            String html = new String(Files.readAllBytes( htmlfile ) );

	            html = html.replace( "${version}", TESTSUITEVERSION );

	        	String table = htmlForCommercialAverages.toString();
	    		html = html.replace( "${table}", table );

	            Files.write( htmlfile, html.getBytes() );
	            System.out.println("Commercial average scorecard computed.");
            } catch( IOException e ) {
                System.out.println( "Error generating commercial scorecard: " + e.getMessage() );
                e.printStackTrace();
            }
        } // end if
	}

    /**
     * This generates the vulnerability stats table that goes at the bottom of each vulnerability category
     * page.
     * @param toolResults - The set of results across all the tools.
     * @param category - The vulnerability category to generate this table for.
     * @return The HTML of the vulnerability stats table.
     */
	private static String generateVulnStatsTable(Set<Report> toolResults, String category) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table class=\"table\">\n");
		sb.append("<tr>");
		sb.append("<th>Tool</th>");
		if (mixedMode) sb.append("<th>" + TESTSUITE + " Version</th>");
		sb.append("<th>TP</th>");
		sb.append("<th>FN</th>");
		sb.append("<th>TN</th>");
		sb.append("<th>FP</th>");
		sb.append("<th>Total</th>");
		sb.append("<th>TPR</th>");
		sb.append("<th>FPR</th>");
		sb.append("<th>Score</th>");
		sb.append("</tr>\n");

		for (Report toolResult : toolResults) {

			if (!(showAveOnlyMode && toolResult.isCommercial())) {
				OverallResults or = toolResult.getOverallResults();
				Map<String, Counter> scores = toolResult.getScores();
				Counter c = scores.get(category);
				OverallResult r = or.getResults(category);
				String style = "";

				if (Math.abs(r.truePositiveRate - r.falsePositiveRate) < .1)
					style = "class=\"danger\"";
				else if (r.truePositiveRate > .7 && r.falsePositiveRate < .3)
					style = "class=\"success\"";
				sb.append("<tr " + style + ">");
				sb.append("<td>" + toolResult.getToolNameAndVersion() + "</td>");
				if (mixedMode) sb.append("<td>" + toolResult.getTestSuiteVersion() + "</td>");
				sb.append("<td>" + c.tp + "</td>");
				sb.append("<td>" + c.fn + "</td>");
				sb.append("<td>" + c.tn + "</td>");
				sb.append("<td>" + c.fp + "</td>");
				sb.append("<td>" + r.total + "</td>");
				sb.append("<td>" + new DecimalFormat("#0.00%").format(r.truePositiveRate) + "</td>");
				sb.append("<td>" + new DecimalFormat("#0.00%").format(r.falsePositiveRate) + "</td>");
				sb.append("<td>" + new DecimalFormat("#0.00%").format(r.score) + "</td>");
				sb.append("</tr>\n");
			}
		}

		sb.append("</table>");
		return sb.toString();
	}

    /**
     * This generates the overall stats table across all the tools that goes at the bottom of the home
     * page.
     * @param toolResults - The set of results across all the tools.
     * @return The HTML of the overall stats table.
     */
	private static String generateOverallStatsTable(Set<Report> toolResults) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table class=\"table\">\n");
		sb.append("<tr>");
		sb.append("<th>Tool</th>");
		if (mixedMode) sb.append("<th>" + TESTSUITE + " Version</th>");
		sb.append("<th>Type</th>");
		sb.append("<th>TPR*</th>");
		sb.append("<th>FPR*</th>");
		sb.append("<th>Score*</th>");
		sb.append("</tr>\n");

		for (Report toolResult : toolResults) {

			if (!(showAveOnlyMode && toolResult.isCommercial())) {
				OverallResults or = toolResult.getOverallResults();
				String style = "";

				if (Math.abs(or.getTruePositiveRate() - or.getFalsePositiveRate()) < .1)
					style = "class=\"danger\"";
				else if (or.getTruePositiveRate() > .7 && or.getFalsePositiveRate() < .3)
					style = "class=\"success\"";
				sb.append("<tr " + style + ">");
				sb.append("<td>" + toolResult.getToolNameAndVersion() + "</td>");
				if (mixedMode) sb.append("<td>" + toolResult.getTestSuiteVersion() + "</td>");
				sb.append("<td>" + toolResult.getToolType() + "</td>");
				sb.append("<td>" + new DecimalFormat("#0.00%").format(or.getTruePositiveRate()) + "</td>");
				sb.append("<td>" + new DecimalFormat("#0.00%").format(or.getFalsePositiveRate()) + "</td>");
				sb.append("<td>" + new DecimalFormat("#0.00%").format(or.getScore()) + "</td>");
				sb.append("</tr>\n");
			}
		}

		sb.append("</table>");
		sb.append("<p>*-Please refer to each tool's scorecard for the data used to calculate these values.");

		return sb.toString();
	}


	/**
	 * This method updates the menus of all the scorecards previously generated so people can navigate
	 * between all the tool results.
	 */
	private static void updateMenus(Set<Report> toolResults, Set<String> catSet ) {

        // Create tool menu
        StringBuffer sb = new StringBuffer();
        for ( Report toolReport : toolResults ) {
			if (!(showAveOnlyMode && toolReport.isCommercial())) {
	            sb.append("<li><a href=\"");
	            sb.append(toolReport.getFilename());
	            sb.append(".html\">");
	            sb.append(toolReport.getToolNameAndVersion());
	            sb.append("</a></li>");
	            sb.append(System.lineSeparator());
			}
        }

        // Before finishing, check to see if there is a commercial average scorecard file, and if so
        // Add it to the menu
        if (commercialAveScorecardFilename != null) {
            sb.append("<li><a href=\"");
            sb.append(commercialAveScorecardFilename);
            sb.append(".html\">");
            sb.append("Commercial Average");
            sb.append("</a></li>");
            sb.append(System.lineSeparator());
        }

        String toolmenu = sb.toString();

        // create vulnerability menu
        sb = new StringBuffer();
        for (String cat : catSet ) {
            String filename = TESTSUITE + "_v" + TESTSUITEVERSION+"_Scorecard_for_" + cat.replace(' ', '_');
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

	// A utility method for providing a more descriptive test suite name than the base, single word,
	// test suite name.
	public static String fullTestSuiteName(String suite) {
		return ("Benchmark".equals(suite) ? "OWASP Benchmark" : suite);
	}

	private static void updateMenuTemplates( String toolmenu, String vulnmenu ) {
	    File root = new File( scoreCardDirName );
	    for ( File f : root.listFiles() ) {
	        if ( !f.isDirectory() && f.getName().endsWith( ".html" ) ) {
	            try {
    	            String html = new String( Files.readAllBytes( f.toPath() ) );
    	            html = html.replace( "${toolmenu}", toolmenu );
    	            html = html.replace( "${vulnmenu}", vulnmenu );
    	            html = html.replace( "${version}", TESTSUITEVERSION );
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
		// Prevent XXE = Note, disabling this entirely breaks the parsing of some XML files, like a Burp results
		// file, so have to use the alternate defense.
		//dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		docBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		docBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource(new FileInputStream(f));
		Document doc = docBuilder.parse(is);
		return doc;
	}
}

