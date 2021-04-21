/**
 * OWASP Benchmark Project
 * <p>
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 * <p>
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 * <p>
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Yuuki Endo / Jason Khoo
 * @created 2020
 */

package org.owasp.benchmark.score.parsers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.owasp.benchmark.score.BenchmarkScore;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckmarxIASTReader extends Reader
{

  private static int cweLookup(String checkerKey)
  {
//    checkerKey = checkerKey.replace("-SECOND-ORDER", "");

    switch (checkerKey)
    {
      case "App_DOS_Database_Connections":
        return 400; // App_DOS_Database_Connections
      case "Blind_SQL_Injection":
        return 89; // sql injection
      case "Click_Jacking":
        return 693; // Click_Jacking
      case "Command_Injection":
        return 78; // Command_Injection
      case "CORS":
        return 346; // CORS
      case "CSRF":
        return 352; // CSRF
      case "Debug_Mode_Enabled":
        return 215; // Debug_Mode_Enabled
      case "Deserialize_Vulnerability":
        return 502; // Deserialize_Vulnerability
      case "Failed_Login_Without_Audit":
        return 778; // Failed_Login_Without_Audit
      case "File_Upload_To_Unprotected_Directory":
        return 434; // File_Upload_To_Unprotected_Directory
      case "Improper_HTTP_Get_Usage":
        return 650; // Improper_HTTP_Get_Usage
      case "Insecure_Cookie":
      case "Session_Id_Disclosure": //CxIAST does not define but it is same as Insecure_Cookie YE
        return 614; // Insecure_Cookie
      case "Insecure_Outgoing_Communication":
        return 311; // Insecure_Outgoing_Communication
      case "Insufficient_Session_Expiration":
        return 613; // Insufficient_Session_Expiration
      case "LDAP_Injection":
        return 90; // LDAP_Injection
      case "Least_Privilege_Violation":
        return 250; // Least_Privilege_Violation
      case "Log_Forging":
        return 117;
      case "Missing_X_Content_Type_Options_Header":
        return 693;
      case "Missing_X_XSS_Protection_Header":
        return 693;
      case "NoSQL_Injection":
        return 943;
      case "Open_Redirect":
        return 601;
      case "Parameter_Pollution":
        return 235;
      case "Parameter_Tampering":
        return 99;
      case "Path_Traversal":
        return 22;
      case "Second_Order_Command_Injection":
        return 77;
      case "Second_Order_LDAP_Injection":
        return 90;
      case "Second_Order_Path_Traversal":
        return 22;
      case "Second_Order_SQL_Injection":
        return 89;
      case "Second_Order_XPath_Injection":
        return 643;
      case "Sensitive_Data_Exposure_Credit_Card":
        return 311;
      case "Sensitive_Data_Exposure_Email":
        return 311;
      case "Sensitive_Data_Exposure_Long_Number":
        return 311;
      case "SQL_Injection":
        return 89;
      case "Stored_XSS":
        return 79;
      case "Successful_Login_Without_Audit":
        return 778;
      case "Trust_Boundary_Violation":
        return 501;
      case "Weak_Cryptography":
        return 327;
      case "Weak_DB_Password":
        return 521;
      case "Weak_Hashing":
        return 328;
      case "Weak_Random":
        return 330;
      case "XPath_Injection":
        return 643;
      case "XSS":
        return 79;
      case "XXE":
        return 611;
    }
    return 0;
  }

  public TestResults parse(File f) throws Exception
  {
    TestResults tr = new TestResults("CxIAST", true, TestResults.ToolType.IAST);

    java.io.Reader inReader = new java.io.FileReader(f);
    Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(inReader);
    for (CSVRecord record : records) {
      String checkerKey = record.get("Vulnerability Type");
      String url = record.get("URL");
//      System.out.println("URL = "+url); //For debugging YE

      TestCaseResult tcr = new TestCaseResult();
      tcr.setCategory(checkerKey);
      tcr.setCWE(cweLookup(checkerKey));
      Pattern testCasePattern = Pattern.compile(BenchmarkScore.TESTCASENAME + "[0-9]{" 
                                   + BenchmarkScore.TESTIDLENGTH + "}");
      Matcher testCaseMatcher = testCasePattern.matcher(url);
      if(testCaseMatcher.find()) {
        String testCase = testCaseMatcher.group(0);
//      System.out.println("testCase = "+testCase+" Test Num = "+testCase.substring(testCase.length()-Utils.TESTCASE_DIGITS, testCase.length())); // For debugging YE
        tcr.setTestCaseName(testCase);
        // BenchmarkTest00000 - BenchmarkTest99999
            tcr.setNumber(Integer.parseInt(testCase.substring(testCase.length() -
                                              BenchmarkScore.TESTIDLENGTH, testCase.length())));
            if (tcr.getCWE() != 0)
            {
                 tr.put(tcr);
            }
//      System.out.println(testCase+" "+tcr.getCWE()+" "+tcr.getCategory()); // For debugging YE
      }
    }
    tr.setTime("100");
    return tr;
  }

}
