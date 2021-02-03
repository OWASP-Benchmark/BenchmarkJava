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

package org.owasp.benchmark.score.parsers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SonarQubeReader extends Reader {

    public TestResults parse(File f) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        byte[] bytes = Files.readAllBytes(f.toPath());

        // Because the Sonar results file is not well formed, i.e., it has multiple root elements, not
        // just one, we have to wrap the contents in a <sonar> element so the XML can be parsed properly
        // by the DocumentBuilder. Without this, you get an error like: org.xml.sax.SAXParseException; 
        // lineNumber: X; columnNumber: YY; The markup in the document following the root element must be well-formed.
        String fixed = "<sonar>" + new String(bytes, "UTF-8") + "</sonar>";
        InputSource is = new InputSource(new ByteArrayInputStream( fixed.getBytes() ) );
        Document doc = docBuilder.parse(is);

        // The OLD SonarQube Java Plug XML format simply started with something like:
        //      <total>NUMFINDINGS</total><languages><name>Java</name><key>java</key>
        // while the new (in 2020) XML format from their SaaS portal starts with this:
        //      <p>20</p><total>NUMFINDINGS</total><components><path> ...
        TestResults tr = null;
        if (fixed.startsWith("<sonar><p>")) {
            // Handle the new XML format
            tr = new TestResults( "SonarQube", false, TestResults.ToolType.SAST);

	        NodeList rootList = doc.getDocumentElement().getChildNodes();

	        List<Node> issueList = getNamedNodes( "issues", rootList );
	        for ( Node flaw : issueList ) {
	            TestCaseResult tcr = parseSonarIssue(flaw);
	            if (tcr != null ) {
	                tr.put(tcr);
	            }
	        }

        } else {
            // Handle the legacy XML format
            tr = new TestResults( "SonarQube Java Plugin", false, TestResults.ToolType.SAST);

	        NodeList rootList = doc.getDocumentElement().getChildNodes();

	        List<Node> issueList = getNamedNodes( "issues", rootList );

	        for ( Node flaw : issueList ) {
	            TestCaseResult tcr = parseSonarPluginIssue(flaw);
	            if (tcr != null ) {
	                tr.put(tcr);
	            }
	        }
        }

        // If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), 
		// set the compute time on the score card. TODO: Move this to BenchmarkScore for ALL tools?
        tr.setTime(f);

        return tr;
    }

    private TestCaseResult parseSonarIssue(Node flaw) {
        TestCaseResult tcr = new TestCaseResult();
        String rule = getNamedChild("rule", flaw).getTextContent();
//System.out.println("Rule # is: " + rule);
        tcr.setCWE( cweLookup( rule.substring( "java:".length() ) ) );

        String cat = getNamedChild("message", flaw).getTextContent();
        tcr.setEvidence( cat );

        String testfile = getNamedChild("component", flaw).getTextContent().trim();
//System.out.println("Found in component: " + testfile);
        testfile = testfile.substring( testfile.lastIndexOf('/') +1 );
        if ( testfile.matches( BenchmarkScore.TESTCASENAME + "\\d+.java" ) ) {
            String testno = testfile.substring( BenchmarkScore.TESTCASENAME.length(),
                     testfile.length() - BenchmarkScore.TESTIDLENGTH );
//System.out.println("Which is determined to be test #: " + testno);
            tcr.setNumber( Integer.parseInt( testno ) );
            return tcr;
        }
        return null;
    }

    private TestCaseResult parseSonarPluginIssue(Node flaw) {
        TestCaseResult tcr = new TestCaseResult();
        String rule = getNamedChild("rule", flaw).getTextContent();
        tcr.setCWE( cweLookup( rule.substring( "squid:".length() ) ) );

        String cat = getNamedChild("message", flaw).getTextContent();
        tcr.setCategory( cat );
        tcr.setConfidence( 5 );
        tcr.setEvidence( cat );

        String testfile = getNamedChild("component", flaw).getTextContent().trim();
        testfile = testfile.substring( testfile.lastIndexOf('/') +1 );
        if ( testfile.matches( BenchmarkScore.TESTCASENAME + "\\d+.java" ) ) {
            String testno = testfile.substring( BenchmarkScore.TESTCASENAME.length(),
                      testfile.length() - BenchmarkScore.TESTIDLENGTH );
            tcr.setNumber( Integer.parseInt( testno ) );
            return tcr;
        }
        return null;
    }

//    //case "Build Misconfiguration" : return 00;
//    case "Command Injection" : return 78;
//    case "Cookie Security" : return 614;
//    case "Cross-Site Scripting" : return 79;
//    //case "Dead Code" : return 00;
//    //case "Denial of Service" : return 00;
//    case "Header Manipulation" : return 113;
//    case "Insecure Randomness" : return 330;
//    //case "J2EE Bad Practices" : return 00;
//    case "LDAP Injection" : return 90;
//    //case "Missing Check against Null" : return 00;
//    //case "Null Dereference" : return 00;
//    case "Password Management" : return 00;
//    case "Path Manipulation" : return 22;
//    //case "Poor Error Handling" : return 00;
//    //case "Poor Logging Practice" : return 00;
//    //case "Poor Style" : return 00;
//    //case "Resource Injection" : return 00;
//    case "SQL Injection" : return 89;
//    //case "System Information Leak" : return 00;
//    case "Trust Boundary Violation" : return 501;
//    //case "Unreleased Resource" : return 00;
//    //case "Unsafe Reflection" : return 00;
//    case "Weak Cryptographic Hash" : return 328;
//    case "Weak Encryption" : return 327;
//    case "XPath Injection" : return 643;

    public static int cweLookup(String squidNumber) {
        // To look up these #'s, go here: https://rules.sonarsource.com/java/RSPEC-#### and put just
        // the #'s with no leading zeroes to look up the 'squid' rule.
        switch( squidNumber ) {
        case "S100"  : return 0000; //Method names should comply with a naming convention
        case "S105" :
        case "S00105" : return 000; //Replace all tab characters in this file by sequences of white-spaces.
        case "S106"  : return 0000; //Replace this usage of System.out or System.err by a logger.
        case "S108"  : return 0000; //Nested blocks of code should not be left empty
        case "S112" :
        case "S00112" : return 397; //Generic exceptions should never be thrown
        case "S115"  : return 0000; //Constant names should comply with a naming convention
        case "S116"  : return 0000; //Field names should comply with a naming convention
        case "S117"  : return 0000; //Local variable and method parameter names should comply with a naming convention
        case "S121" :
        case "S00121" : return 483; //Control structures should always use curly braces
        case "S125"  : return 0000; //Sections of code should not be commented out
        case "S128"  : return 484;  //Switch cases should end with an unconditional"break" statement
        case "S131"  : return 478;  //"switch" statements should have "default" clauses
        case "S135"  : return 0000; //Loops should not contain more than a single "break" or "continue" statement
        case "S864"  : return 783;  //Limited dependence should be placed on operator precedence rules in expressions
        case "S888"  : return 835;  //Relational operators should be used in"for" loop termination conditions
        case "S899"  : return 754;  //Return values should not be ignored when they contain the operation status code
        case "S1066" : return 0000; //Collapsible "if" statements should be merged
        case "S1075" : return 0000; //URIs should not be hardcoded
        case "S1104" : return 493;  //Class variable fields should not have public accessibility
        case "S1116" : return 0000; //Empty statements should be removed
        case "S1117" : return 0000; //Local variables should not shadow class fields
        case "S1118" : return 0000; //Utility classes should not have public constructors
        case "S1128" : return 0000; //Unnecessary imports should be removed
        case "S1130" : return 0000; //"throws" declarations should not be superfluous
        case "S1132" : return 0000; //Strings literals should be placed on the left side when checking for equality
        case "S1134" : return 0000; //Track uses of "FIXME" tags
        case "S1135" : return 0000; //Track uses of "TODO" tags
        case "S1141" : return 0000; //Try-catch blocks should not be nested
        case "S1143" : return 584;  //"return " statements should not occur in "finally" blocks
        case "S1144" : return 0000; //Unused "private" methods should be removed
        case "S1145" : return 0000; //"if" statement conditions should not unconditionally evaluate to"true" or to"false"
        case "S1147" : return 382;  //Exit methods should not be called
        case "S1149" : return 0000; //Synchronized classes Vector, Hashtable, Stack and StringBuffer should not be used
        case "S1155" : return 0000; //Collection.isEmpty() should be used to test for emptiness
        case "S1161" : return 0000; //"@Override" should be used on overriding and implementing methods
        case "S1163" : return 0000; //Exceptions should not be thrown in finally blocks
        case "S1168" : return 0000; //Empty arrays and collections should be returned instead of null
        case "S1171" : return 0000; //Only static class initializers should be used
        case "S1172" : return 0000; //Unused method parameters should be removed
        case "S1174" : return 583;  //"Object.finalize()" should remain protected (versus public) when overriding
        case "S1181" : return 396;  //Throwable and Error should not be caught
        case "S1182" : return 580;  //Classes that override"clone" should be"Cloneable" and call"super.clone()"
        case "S1186" : return 0000; //Methods should not be empty
        case "S1192" : return 0000; //String literals should not be duplicated
        case "S1197" : return 0000; //Array designators "[]" should be on the type, not the variable
        case "S1199" : return 0000; //Nested code blocks should not be used
        case "S1206" : return 581;  //"equals(Object obj)" and"hashCode()" should be overridden in pairs
        case "S1210" : return 0000; //"equals(Object obj)" should be overridden along with the "compareTo(T obj)" method
        case "S1217" : return 572;  //Thread.run() and Runnable.run() should not be called directly
        case "S1301" : return 0000; //"switch" statements should have at least 3 "case" clauses
        case "S1481" : return 0000; //Remove this unused "c" local variable.
        case "S1444" : return 500;  //"public static" fields should always be constant
        case "S1479" : return 0000; //"switch" statements should not have too many "case" clauses
        case "S1488" : return 0000; //Local variables should not be declared and then immediately returned or thrown
        case "S1643" : return 0000; //Strings should not be concatenated using '+' in a loop
        case "S1659" : return 0000; //Multiple variables should not be declared on the same line
        case "S1696" : return 395;  //"NullPointerException" should not be caught
        case "S1698" : return 595;  //Objects should be compared with"equals()"
        case "S1724" : return 0000; //Deprecated classes and interfaces should not be extended/implemented
        case "S1850" : return 0000; //"instanceof" operators that always return "true" or"false" should be removed
        case "S1854" : return 563;  //Unused assignments should be removed
        case "S1872" : return 486;  //Classes should not be compared by name
        case "S1873" : return 582;  //"static final" arrays should be"private"
        case "S1874" : return 0000; //"@Deprecated" code should not be used
        case "S1905" : return 0000; //Redundant casts should not be used
        case "S1948" : return 594;  //Fields in a"Serializable" class should either be transient or serializable
        case "S1989" : return 600;  //Exceptions should not be thrown from servlet methods
        case "S2068" : return 259;  //Credentials should not be hard-coded
        case "S2070" : return 328;  //Benchmark Vuln: SHA-1 and Message-Digest hash algorithms should not be used
        case "S2076" : return 78;   //Benchmark Vuln: Values passed to OS commands should be sanitized
        case "S2077" : return 89;   //Benchmark Vuln: Values passed to SQL commands should be sanitized
        case "S2078" : return 90;   //Benchmark Vuln: Values passed to LDAP queries should be sanitized
        case "S2083" : return 22;   //Benchmark Vuln: I/O function calls should not be vulnerable to path injection attacks
        case "S2089" : return 293;  //HTTP referers should not be relied on
        case "S2091" : return 643;  //Benchmark Vuln: XPath expressions should not be vulnerable to injection attacks
        case "S2092" : return 614;  //Benchmark Vuln: Cookies should be "secure"
        case "S2093" : return 0000; //Try-with-resources should be used
        case "S2095" : return 459;  //Resources should be closed
        case "S2130" : return 0000; //Parsing should be used to convert "Strings" to primitives
        case "S2147" : return 0000; //Catches should be combined
        case "S2157" : return 0000; //"Cloneables" should implement "clone"
        case "S2160" : return 0000; //Subclasses that add fields should override "equals"
        case "S2176" : return 0000; //Class names should not shadow interfaces or superclasses
        case "S2178" : return 0000; //Short-circuit logic should be used in boolean contexts
        case "S2184" : return 190;  //Math operands should be cast before assignment
        case "S2222" : return 459;  //Locks should be released
        case "S2225" : return 476;  //"toString()" and"clone()" methods should not return null
        case "S2245" : return 330;  //Benchmark Vuln: Pseudorandom number generators (PRNGs) should not be used in secure contexts
        case "S2254" : return 0000; //"HttpServletRequest.getRequestedSessionId()" should not be used
        case "S2257" : return 327;  //Benchmark Vuln: Only standard cryptographic algorithms should be used
        case "S2259" : return 476;  //Null pointers should not be dereferenced
        case "S2275" : return 0000; //Printf-style format strings should not lead to unexpected behavior at runtime
        case "S2277" : return 780;  //Cryptographic RSA algorithms should always incorporate OAEP (Optimal Asymmetric Encryption Padding)
        case "S2278" : return 327;  //Benchmark Vuln: DES (Data Encryption Standard) and DESede (3DES) should not be used
        case "S2293" : return 0000; //The diamond operator ("<>") should be used
        case "S2384" : return 374;  //Mutable members should not be stored or returned directly
        case "S2386" : return 607;  //Mutable fields should not be "public static"
        case "S2441" : return 579;  //Non-serializable objects should not be stored in"HttpSessions"
        case "S2479" : return 0000; //Whitespace and control characters in literals should be explicit
        case "S2583" : return 489;  //Conditions should not unconditionally evaluate to"TRUE" or to"FALSE"
        case "S2589" : return 0000; //Boolean expressions should not be gratuitous - CWEs: 570/571
        case "S2658" : return 470;  //Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
        case "S2677" : return 0000; //"read" and "readLine" return values should be used
        case "S2681" : return 483;  //Multiline blocks should be enclosed in curly braces
        case "S2696" : return 0000; //Instance methods should not write to "static" fields
        case "S2755" : return 611;  //XML parsers should not be vulnerable to XXE attacks
        case "S2786" : return 0000; //Nested "enum"s should not be declared static
        case "S2864" : return 0000; //"entrySet()" should be iterated when both the key and value are needed
        case "S3008" : return 0000; //Static non-final field names should comply with a naming convention
        case "S3012" : return 0000; //Arrays should not be copied using loops
        case "S3400" : return 0000; //Methods should not return constants
        case "S3518" : return 369;  //Zero should not be a possible denominator
        case "S3599" : return 0000; //Double Brace Initialization should not be used
        case "S3626" : return 0000; //Jump statements should not be redundant
        case "S3649" : return 89;   //Database queries should not be vulnerable to injection attacks
        case "S3740" : return 0000; //Raw types should not be used
        case "S3776" : return 0000; //Cognitive Complexity of methods should not be too high
        case "S3824" : return 0000; //"Map.get" and value test should be replaced with single method call
        case "S3973" : return 0000; //A conditionally executed single line should be denoted by indentation
        case "S4042" : return 0000; //"java.nio.Files#delete" should be preferred
        case "S4435" : return 611;  //XML transformers should be secured
        case "S4488" : return 0000; //Composed "@RequestMapping" variants should be preferred
        case "S4719" : return 0000; //"StandardCharsets" constants should be preferred
        case "S4838" : return 0000; //An iteration on a Collection should be performed on the type handled by the Collection
        case "S5131" : return 79;   //Endpoints should not be vulnerable to reflected cross-site scripting (XSS) attacks
        case "S5261" : return 0000; //"else" statements should be clearly matched with an "if"
        case "S5361" : return 0000; //"String#replace" should be preferred to "String#replaceAll"
        case "S5542" : return 327;  //Benchmark Vuln: Encryption algorithms should be used with secure mode and padding scheme
        case "S5547" : return 327;  //Benchmark Vuln: Cipher algorithms should be robust

        case "CallToDeprecatedMethod":
        case "ClassVariableVisibilityCheck":
        case "DuplicatedBlocks":
        case "SwitchLastCaseIsDefaultCheck":
                return 0000; // Don't care. Not sure why these are being returned instead of an S#### value
        }

        System.out.println( "Failed to translate " + squidNumber );
        return -1;
    }
}
