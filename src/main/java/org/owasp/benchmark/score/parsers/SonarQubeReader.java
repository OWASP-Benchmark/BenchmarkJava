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
        String fixed = "<sonar>" + new String(bytes, "UTF-8") + "</sonar>";
        InputSource is = new InputSource(new ByteArrayInputStream( fixed.getBytes() ) );
        Document doc = docBuilder.parse(is);

        TestResults tr = new TestResults( "SonarQube Java Plugin" ,false,TestResults.ToolType.SAST);

        // If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), 
		// set the compute time on the score card.
        tr.setTime(f);
        
        NodeList rootList = doc.getDocumentElement().getChildNodes();

        List<Node> issueList = getNamedNodes( "issues", rootList );

        for ( Node flaw : issueList ) {
            TestCaseResult tcr = parseSonarIssue(flaw);
            if (tcr != null ) {
                tr.put(tcr);
            }
        }
        return tr;
    }

    private TestCaseResult parseSonarIssue(Node flaw) {
        TestCaseResult tcr = new TestCaseResult();
        String rule = getNamedChild("rule", flaw).getTextContent();
        tcr.setCWE( cweLookup( rule.substring( "squid:".length() ) ) );

        String cat = getNamedChild("message", flaw).getTextContent();
        tcr.setCategory( cat );

        tcr.setConfidence( 5 );

        tcr.setEvidence( cat );

        String testfile = getNamedChild("component", flaw).getTextContent().trim();
        testfile = testfile.substring( testfile.lastIndexOf('/') +1 );
        if ( testfile.matches( BenchmarkScore.BENCHMARKTESTNAME + "\\d+.java" ) ) {
            String testno = testfile.substring( BenchmarkScore.BENCHMARKTESTNAME.length(), testfile.length() -5 );
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
        switch( squidNumber ) {
        case "S00105" : return 0000; //S00105-Replace all tab characters in this file by sequences of white-spaces.
        case "S106" : return 0000; //S00106-Replace this usage of System.out or System.err by a logger.
        case "S00112" : return 397; //S00112-Generic exceptions should never be thrown
        case "S00121" : return 483; //S00121-Control structures should always use curly braces
        case "S1132" : return 0000; //S1132-Move the "foo" string literal on the left side of this string comparison.
        case "S1143" : return 584; //S1143-"return " statements should not occur in"finally" blocks
        case "S1145" : return 0000; //S1145-"if" statement conditions should not unconditionally evaluate to"true" or to"false"
        case "S1147" : return 382; //S1147-Exit methods should not be called
        case "S1174" : return 583; //S1174-"Object.finalize()" should remain protected (versus public) when overriding
        case "S1181" : return 396; //S1181-Throwable and Error should not be caught
        case "S1182" : return 580; //S1182-Classes that override"clone" should be"Cloneable" and call"super.clone()"
        case "S1206" : return 581; //S1206-"equals(Object obj)" and"hashCode()" should be overridden in pairs
        case "S1217" : return 572; //S1217-Thread.run() and Runnable.run() should not be called directly
        case "S128" : return 484; //S128-Switch cases should end with an unconditional"break" statement
        case "S1481" : return 0000; //1481-Remove this unused "c" local variable.
        case "S1444" : return 500; //S1444-"public static" fields should always be constant
        case "S1696" : return 395; //S1696-"NullPointerException" should not be caught
        case "S1698" : return 595; //S1698-Objects should be compared with"equals()"
        case "S1724" : return 0000; //S1724-Deprecated classes and interfaces should not be extended/implemented
        case "S1850" : return 0000; //S1850-"instanceof" operators that always return "true" or"false" should be removed
        case "S1872" : return 486; //S1872-Classes should not be compared by name
        case "S1873" : return 582; //S1873-"static final" arrays should be"private"
        case "S1948" : return 594; //S1948-Fields in a"Serializable" class should either be transient or serializable
        case "S2068" : return 259; //S2068-Credentials should not be hard-coded
        case "S2070" : return 328; //S2070-SHA-1 and Message-Digest hash algorithms should not be used
        case "S2076" : return 78; //S2076-Values passed to OS commands should be sanitized
        case "S2077" : return 89; //S2077-Values passed to SQL commands should be sanitized
        case "S2078" : return 90; //S2078-Values passed to LDAP queries should be sanitized
        case "S2089" : return 293; //S2089-HTTP referers should not be relied on
        case "S2092" : return 614; //S2092-Cookies should be"secure"
        case "S2095" : return 459; //S2095-Resources should be closed
        case "S2184" : return 190; //S2184-Math operands should be cast before assignment
        case "S2222" : return 0000; //S2222-Locks should be released
        case "S2225" : return 0000; //S2225-"toString()" and"clone()" methods should not return  null
        case "S2245" : return 330; //S2245-Pseudorandom number generators (PRNGs) should not be used in secure contexts
        case "S2254" : return 0000; //S2254-"HttpServletRequest.getRequestedSessionId()" should not be used
        case "S2257" : return 327; //S2257-Only standard cryptographic algorithms should be used
        case "S2259" : return 476; //S2259-Null pointers should not be dereferenced
        case "S2277" : return 780; //S2277-Cryptographic RSA algorithms should always incorporate OAEP (Optimal Asymmetric Encryption Padding)
        case "S2278" : return 327; //S2278-DES (Data Encryption Standard) and DESede (3DES) should not be used
        case "S2384" : return 374; //S2384-Mutable members should not be stored or returned directly
        case "S2441" : return 579; //S2441-Non-serializable objects should not be stored in"HttpSessions"
        case "S2583" : return 489; //S2583-Conditions should not unconditionally evaluate to"TRUE" or to"FALSE"
        case "S864" : return 783; //S864-Limited dependence should be placed on operator precedence rules in expressions
        case "S888" : return 835; //S888-Relational operators should be used in"for" loop termination conditions
        }
        // System.out.println( "Failed to translate " + squidNumber );
        return -1;
    }

}

