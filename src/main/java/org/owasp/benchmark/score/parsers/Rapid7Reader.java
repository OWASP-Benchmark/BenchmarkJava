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

public class Rapid7Reader extends Reader {
	
	public TestResults parse( Node root ) throws Exception {
        TestResults tr = new TestResults( "Rapid7 AppSpider", true, TestResults.ToolType.DAST);

//        <VulnSummary>
//        <AppVersion>6.4.258.1</AppVersion>
//        <ScanName>OwaspBenchmark</ScanName>
//        <Metadata></Metadata>
//        <ScanStarted>2015-09-17 13:17:21</ScanStarted>
//        <ScanDuration>00:24:37</ScanDuration>
//        <ScanEnded>2015-09-17 13:41:59</ScanEnded>
//        <UTCOffset>-5</UTCOffset>
//        <ResourcesCrawled>340</ResourcesCrawled>
//        <NumberOfRequests>35374</NumberOfRequests>
//        <NumberOfFailedRequests>0</NumberOfFailedRequests>
//        <VulnList>
//          <Vuln>
//          </Vuln>
//        </VulnList>
//        </VulnSummary>

        String duration = getNamedChild("ScanDuration", root ).getTextContent();
        tr.setTime( duration );

        String version = getNamedChild("AppVersion", root ).getTextContent();
        tr.setToolVersion( version );
        
        Node issues = getNamedChild( "VulnList", root );
        List<Node> issueList = getNamedChildren( "Vuln", issues );
        
        for ( Node issue : issueList ) {
            try {
                TestCaseResult tcr = parseRapid7Item(issue);
                if (tcr != null ) {
                    tr.put(tcr);
                    //System.out.println( tcr.getCWE() + ", " + tcr.getEvidence() + ", " + tcr.getNumber() );
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        return tr;
	}
	
    //	<Vuln>
    //	<DbId>B505FC30B7AF4831B7EB491B6BC06867</DbId>
    //	<ParentDbId>00000000000000000000000000000000</ParentDbId>
    //	<ScanName>OwaspBenchmark</ScanName>
    //	<WebSite>https://localhost:8443</WebSite>
    //	<WebSiteIP>127.0.0.1</WebSiteIP>
    //	<VulnType>HTTP Strict Transport Security</VulnType>
    //	<VulnUrl>https://localhost:8443/benchmark/</VulnUrl>
    //	<NormalizedUrl>https://localhost:8443/benchmark/</NormalizedUrl>
    //	<MatchedString></MatchedString>
    //	<NormalizedPostParams></NormalizedPostParams>
    //	<VulnParam></VulnParam>
    //	<ParameterName>N/A</ParameterName>
    //	<HtmlEntityAttacked>URL</HtmlEntityAttacked>
    //	<ModuleId>EBEE6CA2515F4FBEB8B7EC0197C5A74F</ModuleId>
    //	<AttackType>Strict-Transport-Security header not found in the response from HTTPS site</AttackType>
    //	<AttackScore>1-Informational</AttackScore>
    //	<AttackValue>N/A</AttackValue>
    //	<Method>N/A</Method>
    //	<RootCauseId>5F9BD410EA30F0D2F00CC9050F86280D</RootCauseId>
    //	<FindingDbId>3A20B126E16E444E8C75CFAD2670B95C</FindingDbId>
    //	<Description><![CDATA[<p><p>If a web site accepts a connection through HTTP and redirects to HTTPS, the user in this case may initially talk to the non-encrypted version of the site before being redirected, if, for example, the user types http://www.foo.com/ or even just foo.com.
    //	                    The HTTP Strict Transport Security feature lets a web site inform the browser that it should never load the site using HTTP, and should automatically convert all attempts to access the site using HTTP to HTTPS requests instead.</p>]]></Description>
    //	<Recommendation><![CDATA[<p>HSTS header is a mechanism that web sites have to communicate to the web browsers that all traffic exchanged with a given domain must always be sent over https, this will help protect the information from being passed over unencrypted requests.
    //	                  Considering the importance of this security measure is important to verify that the web site using this HTTP header, in order to ensure that all the data travels encrypted from the web browser to the server.</p>]]></Recommendation>
    //	<Page>https://localhost:8443/benchmark/</Page>
    //	<Url>https://localhost:8443/benchmark/</Url>
    //	<VulnParamType>unknown</VulnParamType>
    //	<CrawlTraffic>R0VUIC9iZW5jaG1hcmsvIEhUVFAvMS4xDQpBY2NlcHQ6IHRleHQvaHRtbCxhcHBsaWNhdGlvbi94aHRtbCt4bWwsYXBwbGljYXRpb24veG1sO3E9MC45LCovKjtxPTAuOA0KQWNjZXB0LUNoYXJzZXQ6ICoNCkFjY2VwdC1FbmNvZGluZzogZ3ppcCwgZGVmbGF0ZQ0KQWNjZXB0LUxhbmd1YWdlOiBlbi1VUw0KVXNlci1BZ2VudDogTW96aWxsYS81LjAgKGNvbXBhdGlibGU7IE1TSUUgOS4wOyBXaW5kb3dzIE5UIDYuMTsgV09XNjQ7IFRyaWRlbnQvNS4wKQ0KSG9zdDogbG9jYWxob3N0Ojg0NDMNCg0K</CrawlTraffic>
    //	<CrawlTrafficTemplate>R0VUIC9iZW5jaG1hcmsvIEhUVFAvMS4xDQpBY2NlcHQ6IHRleHQvaHRtbCxhcHBsaWNhdGlvbi94aHRtbCt4bWwsYXBwbGljYXRpb24veG1sO3E9MC45LCovKjtxPTAuOA0KQWNjZXB0LUNoYXJzZXQ6ICoNCkFjY2VwdC1FbmNvZGluZzogZ3ppcCwgZGVmbGF0ZQ0KQWNjZXB0LUxhbmd1YWdlOiBlbi1VUw0KVXNlci1BZ2VudDogTW96aWxsYS81LjAgKGNvbXBhdGlibGU7IE1TSUUgOS4wOyBXaW5kb3dzIE5UIDYuMTsgV09XNjQ7IFRyaWRlbnQvNS4wKQ0KSG9zdDogbG9jYWxob3N0Ojg0NDMNCg0K</CrawlTrafficTemplate>
    //	<CrawlTrafficResponse>SFRUUC8xLjEgMjAwIE9LDQpEYXRlOiBUaHUsIDE3IFNlcCAyMDE1IDE4OjE3OjM2IEdNVA0KQ29udGVudC1MZW5ndGg6IDEwMzUNCkNvbnRlbnQtVHlwZTogdGV4dC9odG1sDQpMYXN0LU1vZGlmaWVkOiBUaHUsIDE3IFNlcCAyMDE1IDE4OjAxOjE2IEdNVA0KQWNjZXB0LVJhbmdlczogYnl0ZXMNCkVUYWc6IFcvIjEwMzUtMTQ0MjUxMjg3NjAwMCINClNlcnZlcjogQXBhY2hlLUNveW90ZS8xLjENCg0KPCFET0NUWVBFIGh0bWwgUFVCTElDICItLy9XM0MvL0RURCBIVE1MIDQuMDEgVHJhbnNpdGlvbmFsLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL1RSL2h0bWw0L2xvb3NlLmR0ZCI+DQo8aHRtbD4NCjxoZWFkPg0KPG1ldGEgaHR0cC1lcXVpdj0iQ29udGVudC1UeXBlIiBjb250ZW50PSJ0ZXh0L2h0bWw7IGNoYXJzZXQ9SVNPLTg4NTktMSI+DQo8dGl0bGU+T1dBU1AgQmVuY2htYXJrPC90aXRsZT4NCjwvaGVhZD4NCjxib2R5Pg0KCTxoMT5PV0FTUCBCZW5jaG1hcmsgVGVzdCBDYXNlIEluZGV4PC9oMT4NCgk8aDM+QXZhaWxhYmxlIENhdGVnb3JpZXM8aDM+DQo8YSBocmVmPSdjbWRpLUluZGV4Lmh0bWwnPkNvbW1hbmQgSW5qZWN0aW9uIENhdGVnb3J5PC9hPjxici8+DQo8YSBocmVmPSdjcnlwdG8tSW5kZXguaHRtbCc+Q3J5cHRvZ3JhcGhpYyBDYXRlZ29yeTwvYT48YnIvPg0KPGEgaHJlZj0naGFzaC1JbmRleC5odG1sJz5XZWFrIEhhc2hpbmcgQ2F0ZWdvcnk8L2E+PGJyLz4NCjxhIGhyZWY9J2xkYXBpLUluZGV4Lmh0bWwnPkxEQVAgSW5qZWN0aW9uIENhdGVnb3J5PC9hPjxici8+DQo8YSBocmVmPSdwYXRodHJhdmVyLUluZGV4Lmh0bWwnPlBhdGggVHJhdmVyc2FsIENhdGVnb3J5PC9hPjxici8+DQo8YSBocmVmPSdzZWN1cmVjb29raWUtSW5kZXguaHRtbCc+U2VjdXJlIENvb2tpZSBDYXRlZ29yeTwvYT48YnIvPg0KPGEgaHJlZj0nc3FsaS1JbmRleC5odG1sJz5TUUwgSW5qZWN0aW9uIENhdGVnb3J5PC9hPjxici8+DQo8YSBocmVmPSd0cnVzdGJvdW5kLUluZGV4Lmh0bWwnPlRydXN0IEJvdW5kYXJ5IENhdGVnb3J5PC9hPjxici8+DQo8YSBocmVmPSd3ZWFrcmFuZC1JbmRleC5odG1sJz5XZWFrIFJhbmRvbW5lc3MgQ2F0ZWdvcnk8L2E+PGJyLz4NCjxhIGhyZWY9J3hwYXRoaS1JbmRleC5odG1sJz5YUEFUSCBJbmplY3Rpb24gQ2F0ZWdvcnk8L2E+PGJyLz4NCjxhIGhyZWY9J3hzcy1JbmRleC5odG1sJz5YU1MgKENyb3NzLVNpdGUgU2NyaXB0aW5nKSBDYXRlZ29yeTwvYT48YnIvPg0KPC9ib2R5Pg0KPC9odG1sPg0K</CrawlTrafficResponse>
    //	<AttackClass>Best Practice</AttackClass>
    //	<CweId>0</CweId>
    //	<CAPEC>0</CAPEC>
    //	<DISSA_ASC>0</DISSA_ASC>
    //	<OWASP2007>0</OWASP2007>
    //	<OWASP2010>0</OWASP2010>
    //	<OWASP2013>0</OWASP2013>
    //	<OVAL>0</OVAL>
    //	<WASC>0</WASC>
    //	<ScanDate>2015-09-17 13:17:21</ScanDate>
    //	<ScanEnd>2015-09-17 13:41:59</ScanEnd>
    //	<StatisticallyPrevalentOriginalResponseCode>200</StatisticallyPrevalentOriginalResponseCode>
    //	<DefenseBL>
    //	<DbId>E2A6AE6C56DF4BFFACE65CB3E276D4F8</DbId>
    //	<ParentDbId>B505FC30B7AF4831B7EB491B6BC06867</ParentDbId>
    //	<PcreRegex></PcreRegex>
    //	<ModSecurity></ModSecurity>
    //	<Snort></Snort>
    //	<Imperva></Imperva>
    //	</DefenseBL>
    //	<DefenseWL>
    //	<DbId>E99AA70309A7407ABE053AE7BBAE2CCF</DbId>
    //	<ParentDbId>B505FC30B7AF4831B7EB491B6BC06867</ParentDbId>
    //	<PcreRegex></PcreRegex>
    //	<ModSecurity></ModSecurity>
    //	<Snort></Snort>
    //	<Imperva></Imperva>
    //	</DefenseWL>
    //	<AttackList>
    //	<Attack>
    //	<DbId>067CCE8F85C0480A867CCB601381366C</DbId>
    //	<ParentDbId>00000000000000000000000000000000</ParentDbId>
    //	<AttackId>HSTSAttack_1</AttackId>
    //	<AttackValue></AttackValue>
    //	<AttackVulnUrl>https://localhost:8443/benchmark/</AttackVulnUrl>
    //	<AttackPostParams></AttackPostParams>
    //	<AttackMatchedString></AttackMatchedString>
    //	<AttackDescription></AttackDescription>
    //	<AttackConfigDescription>Strict-Transport-Security header not found in the response from HTTPS site</AttackConfigDescription>
    //	<OriginalResponseCode>200</OriginalResponseCode>
    //	</Attack>
    //	</AttackList>
    //	</Vuln>

	private TestCaseResult parseRapid7Item( Node flaw ) throws Exception {
        TestCaseResult tcr = new TestCaseResult();

        String type = getNamedChild("VulnType", flaw).getTextContent();
        tcr.setCategory( type );

        String evidence = getNamedChild("AttackType", flaw).getTextContent();
        tcr.setEvidence( evidence );

        Node vulnId = getNamedChild("CweId", flaw);
        if ( vulnId != null ) {
            String cweNum = vulnId.getTextContent();
            int cwe = cweLookup( cweNum, evidence );
            tcr.setCWE( cwe  );
        }
        
        String uri = getNamedChild( "Url", flaw ).getTextContent();
        int spaceIdx = uri.indexOf( ' ' );
        if ( spaceIdx != -1 ) {
            uri = uri.substring( 0, spaceIdx );
        }
        String testfile = uri.substring( uri.lastIndexOf('/') +1 );
        if ( testfile.contains("?") ) {
            testfile = testfile.substring(0, testfile.indexOf( "?" ) );
        }
        
        if ( testfile.startsWith( BenchmarkScore.TESTCASENAME ) ) {
            String testno = testfile.substring(BenchmarkScore.TESTCASENAME.length());
            if ( testno.endsWith( ".html" ) ) {
                testno = testno.substring(0, testno.length() -5 );
            }
            try {
                tcr.setNumber( Integer.parseInt( testno ) );
                return tcr;
            } catch( NumberFormatException e ) {
                System.out.println( "> Parse error " + testfile + ":: " + testno );
            }
        }
        return null;
    }

	
	private static int cweLookup( String cweNum, String evidence ) {
	    int cwe = 0000;
	    if ( cweNum != null && !cweNum.isEmpty() ) {
	      cwe = Integer.parseInt( cweNum );
	    }

	    switch( cwe ) {
	      case 0  : switch( evidence ) {
				// These are the ones we've seen. Print out any new ones to make sure its mapped properly.
				case "Reflection": return 79; // Causes their XSS score to go from 0% to: TP:34.55% FP:11.48%

				case "Customer Authentication Credential (Username)":
				case "Email address":
				case "Javascript \"strict mode\" is not defined.":
				case "Left arrow":
				case "Mobile Browser":
				case "Stored Discover number":
				case "Stored MasterCard number":
				case "Stored Visa number":
				case "Strict-Transport-Security header not found in the response from HTTPS site":
				case "The Content Security Policy hasn't been declared either through the meta-tag or the header.":
				case "Undefined charset attribute":
				case "X-Content-Type-Options header not found":
				case "X-Frame-Options HTTP header checking":
				case "X-XSS-Protection header not found": return 0;
				default: {
					// If this prints out anything new, add to this mapping so we know it's mapped properly.
					System.out.println("Found new unmapped finding with evidence: " + evidence);
					return 0;   // In case they add any new mappings
				}
			}
	      case 79  : switch( evidence ) {
				case "HttpOnly attribute not set": return 1004; // Mapping to more specific CWE
				default: return 79;   // Leave the rest as is
			}
	      case 80  : switch( evidence ) {
				// These map Basic XSS to XSS - Causing their XSS TP rate to go up almost 12%
				case "Filter evasion - script alert injection, no round brackets": return 79;
				case "Filter evasion - script prompt injection, no round brackets": return 79;
				case "SameSite attribute is not set to \"strict\" or \"lax\"": return 352;
				case "Unfiltered <script> tag after single quotation mark": return 79;
				case "Unfiltered <script> tag after double quotation mark": return 79;
				case "Unfiltered <script> tag": return 79;
				case "body with onload (original)": return 79;
				case "img tag with onerror": return 79;
				case "script include": return 79;
				case "script tag": return 79;
				default: {
					// If this prints out anything new, add to this mapping so we know it's mapped properly.
					System.out.println("Found new CWE 80 (mapping to 79) with evidence: " + evidence);
					return 79;   // In case they add any new mappings
				}
			}
	      case 201 : return 89;   // SQL instruction files - This causes their TP rate to go up 4% but FP rate up 6.5%
	      case 209 : return 89;   // Find SQL query constructions - This causes their TP rate to go up 2.5% but FP rate up 7.75%

//        case "insecure-cookie"           :  return 614;  // insecure cookie use
//        case "sql-injection"             :  return 89;   // sql injection
//        case "cmd-injection"             :  return 78;   // command injection
//        case "ldap-injection"            :  return 90;   // ldap injection
//        case "header-injection"          :  return 113;  // header injection
//        case "hql-injection"             :  return 0000; // hql injection
//        case "unsafe-readline"           :  return 0000; // unsafe readline
//        case "reflection-injection"      :  return 0000; // reflection injection
//        case "reflected-xss"             :  return 79;   // xss
//        case "xpath-injection"           :  return 643;  // xpath injection
//        case "path-traversal"            :  return 22;   // path traversal
//        case "crypto-bad-mac"            :  return 328;  // weak hash
//        case "crypto-weak-randomness"    :  return 330;  // weak random
//        case "crypto-bad-ciphers"        :  return 327;  // weak encryption
//        case "trust-boundary-violation"  :  return 501;  // trust boundary
//        case "xxe"                       :  return 611;  // xml entity

        }
		return cwe;
	}

}
