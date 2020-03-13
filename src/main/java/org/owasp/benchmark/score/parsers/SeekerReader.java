/**
 * OWASP Benchmark Project
 * <p>
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
 * <p>
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 * <p>
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
 * @created 2015
 */

package org.owasp.benchmark.score.parsers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class SeekerReader extends Reader
{

  private static int cweLookup(String checkerKey)
  {
    checkerKey = checkerKey.replace("-SECOND-ORDER", "");

    switch (checkerKey)
    {
      case "COOK-SEC":
        return 614; // insecure cookie use
      case "SQLI":
        return 89; // sql injection
      case "CMD-INJECT":
        return 78; // command injection
      case "LDAP-INJECTION":
        return 90; // ldap injection
      case "header-injection":
        return 113; // header injection
      case "hql-injection":
        return 564; // hql injection
      case "unsafe-readline":
        return 0000; // unsafe readline
      case "reflection-injection":
        return 0000; // reflection injection
      case "R-XSS":
        return 79; // xss
      case "XPATH-INJECT":
        return 643; // xpath injection
      case "DIR-TRAVERSAL":
        return 22; // path traversal
      case "crypto-bad-mac":
        return 328; // weak hash
      case "crypto-weak-randomness":
        return 330; // weak random
      case "WEAK-ENC":
        return 327; // weak encryption
      case "trust-boundary-violation":
        return 501; // trust boundary
      case "xxe":
        return 611; // xml entity
      case "WEAK-HASH":
        return 328;
      case "WEAK-RANDOM-GENERATOR":
        return 330;
      case "TRUST-BOUNDARY-VIOLATION":
        return 501;		
    }
    return 0;
  }

  public TestResults parse(File f) throws Exception
  {
    TestResults tr = new TestResults("Seeker", true, TestResults.ToolType.IAST);

    java.io.Reader inReader = new java.io.FileReader(f);
    Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(inReader);
    for (CSVRecord record : records)
    {
      String checkerKey = record.get("CheckerKey");
      String url = record.get("LastDetectionURL");

      TestCaseResult tcr = new TestCaseResult();
      tcr.setCategory(checkerKey);
      tcr.setCWE(cweLookup(checkerKey));
      try
      {
        if (url.length() >= 5)
        {
          tcr.setNumber(Integer.parseInt(url.substring(url.length() - 5, url.length())));
        }
      }
      catch (NumberFormatException e)
      {
        System.out.println("> Parse error: " + record.toString());
      }

      if (tcr.getCWE() != 0)
      {        
        tr.put(tcr);
      }
    }

    tr.setTime("100");

    return tr;
  }

}
