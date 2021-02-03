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

import java.util.List;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Node;

public class NoisyCricketReader extends Reader {
	
	public TestResults parse( Node root ) throws Exception {
		TestResults tr = new TestResults( "NoisyCricket", false, TestResults.ToolType.SAST);		
		tr.setTime("1 minute");
		Node meta = getNamedChild( "meta", root );
        tr.setToolVersion( getAttributeValue( "version", meta ) );

        Node vulns = getNamedChild( "vulnerabilities", root );
        List<Node> items = getNamedChildren("vulnerability", vulns );
        for ( Node item : items ) {
            try {
                parseNoisyCricketIssue( item, tr );
            } catch( Exception e ) {
                e.printStackTrace();
            }
		}
		
		return tr;
	}
	
	private void parseNoisyCricketIssue(Node item, TestResults tr) {
		int testNumber = -1;
        String testcase = getAttributeValue("file", item);
        if (testcase.startsWith(BenchmarkScore.TESTCASENAME)) {
            String testno = testcase.substring(BenchmarkScore.TESTCASENAME.length(), testcase.indexOf('.'));
            try {
                testNumber = Integer.parseInt(testno);
            } catch (NumberFormatException e) {
                return;
            }
        }

        String cwelist = getAttributeValue("cwelist",item);
        cwelist = cwelist.substring(1,cwelist.length()-1);
        if ( !cwelist.isEmpty() ) {
            String[] cwes = cwelist.split(", ");
            for ( String cwe: cwes ) {
                TestCaseResult tcr = new TestCaseResult();
                tcr.setNumber( testNumber );
                tcr.setCWE( Integer.parseInt(cwe) );
                tr.put( tcr );
            }
        }
        return;
	}

}
