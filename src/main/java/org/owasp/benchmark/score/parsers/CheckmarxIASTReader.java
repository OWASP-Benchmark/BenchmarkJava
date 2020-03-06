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
 * @author Grant Ongers <a href="https://www.securedelivery.io">Secure Delivery</a>
 * @created 2020
 */

package org.owasp.benchmark.score.parsers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CheckmarxIASTReader extends Reader
{

  public TestResults parse(File f) throws Exception
  {
    TestResults tr = new TestResults("Checkmarx CxIAST", true, TestResults.ToolType.IAST);

    java.io.Reader inReader = new java.io.FileReader(f);
    Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(inReader);
    for (CSVRecord record : records)
    {
      String cwe = record.get("CWE");
      String url = record.get("URL");

      TestCaseResult tcr = new TestCaseResult();
      try
      {
        if (url.length() >= 18)
        {
          String category = url.substring(1, url.indexOf("-"));
          tcr.setNumber(Integer.parseInt(url.substring(url.indexOf("BenchmarkTest")+13, url.indexOf("BenchmarkTest")+18)));
          if ( cwe.length() == 0 && category == "securecookie" ) tcr.setCWE(614); //CxIAST doesn't report on all 614
          else if ( cwe.length() == 0 ) tcr.setCWE(0);
          else tcr.setCWE(Integer.parseInt(cwe));
        }
      }
      catch (NumberFormatException e)
      {
        System.out.println("> TParse error: " + record.toString());
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
