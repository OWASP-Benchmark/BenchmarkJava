package org.owasp.benchmark.score.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.owasp.benchmark.score.parsers.TestResults.ToolType;

public class ShiftLeftReader extends Reader {
  public TestResults parse(File f) throws IOException {

    TestResults tr = new TestResults("ShiftLeft", true, ToolType.SAST);
    BufferedReader reader = new BufferedReader(new FileReader(f));

    String line;
    while ( (line = reader.readLine() ) != null ) {

        String[] split = line.split(",");
        if (split.length != 2) {
          throw new RuntimeException("Invalid line in SL result file.");
        }

        int number = Integer.parseInt(split[0]);
        String category = split[1];

        TestCaseResult testCaseResult = new TestCaseResult();
        testCaseResult.setCategory(category);
        testCaseResult.setNumber(number);
        testCaseResult.setCWE(categoryToCWE(category));
        testCaseResult.setEvidence(line);

        tr.put(testCaseResult);
    }

    reader.close();
    return tr;
  }

  private int categoryToCWE(String category) {
    switch(category) {
      case "cmdi":
        return 78;
      case "crypto":
        return 327;
      case "hash":
        return 328;
      case "ldapi":
        return 90;
      case "pathtraver":
        return 22;
      case "securecookie":
        return 614;
      case "sqli":
        return 89;
      case "trustbound":
        return 501;
      case "weakrand":
        return 330;
      case "xpathi":
        return 643;
      case "xss":
        return 79;
        default:
      throw new RuntimeException("Unknown category: " + category);
    }
  }
}
