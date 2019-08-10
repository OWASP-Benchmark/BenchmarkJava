package org.owasp.benchmark.score.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.owasp.benchmark.score.parsers.TestResults.ToolType;
import org.owasp.benchmark.score.BenchmarkScore;

public class SecurityPrismReader extends Reader {
  public TestResults parse(File f) throws IOException {

    TestResults tr = new TestResults("SecurityPrism", true, ToolType.SAST);
    BufferedReader reader = new BufferedReader(new FileReader(f));

    String line;
    while ( (line = reader.readLine() ) != null ) {

        String[] split = line.split(",");
        if (split.length < 3) {
          throw new RuntimeException("Invalid line in SecurityPrism out file.");
        }

        String path   = split[0].substring(2, split[0].length() - 1);
        String ruleid = split[2].substring(1);

        String[] paths = path.split("/");
        String testfile = paths[paths.length - 1];


        // int number = Integer.parseInt(split[0]);
        // String category = split[1];

        TestCaseResult tcr = new TestCaseResult();

        if ( ruleid.endsWith(")") ) ruleid = ruleid.substring(0, ruleid.length() -2);
        else ruleid = ruleid.substring(0, ruleid.length() -1);

        if ( testfile.startsWith( BenchmarkScore.BENCHMARKTESTNAME ) ) {
            String testno = testfile.substring(BenchmarkScore.BENCHMARKTESTNAME.length());
            if ( testno.endsWith( ".html" ) || testno.endsWith( ".java" )) {
                testno = testno.substring(0, testno.length() -5 );
            } else if ( testno.endsWith( ".xml" ) ) {
                testno = testno.substring(0, testno.length() -4 );
            } 
            try {
                tcr.setNumber( Integer.parseInt( testno ) );
            } catch( NumberFormatException e ) {
                System.out.println( "> Parse error " + testfile + ":: " + testno );
            }
        }

        tcr.setCWE(ruleidToCWE(ruleid));
        tcr.setCategory(ruleid);

        // testCaseResult.setCategory(category);
        // testCaseResult.setNumber(number);
        // testCaseResult.setCWE(categoryToCWE(category));
        // testCaseResult.setEvidence(line);

        tr.put(tcr);
    }

    reader.close();
    return tr;
  }

  private int ruleidToCWE(String ruleid) {
    int cwe = 0;
    try {
      cwe = Integer.parseInt( ruleid );
      cwe = cwe - 45110000;
      if (cwe > 999) cwe = 0;
      if (cwe == 80) cwe = 79;
    } catch( NumberFormatException e ) {
      System.out.println( "> Transform error " + ruleid + ":: " + cwe );
    }

    return cwe;
  }

}
