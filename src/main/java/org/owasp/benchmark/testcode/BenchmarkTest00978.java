/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00978")
public class BenchmarkTest00978 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = "";
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("vector")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					break;
				}
			}
		}

		String bar = new Test().doSomething(param);
		
		String cmd = "";	
		String a1 = "";
		String a2 = "";
		String[] args = null;
		String osName = System.getProperty("os.name");
		
		if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        	cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        	args = new String[]{a1, a2, cmd, bar};
        } else {
        	a1 = "sh";
        	a2 = "-c";
        	cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("ping -c1");
                args = new String[]{a1, a2, cmd, bar};
        }
		
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args);
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61888 = param; //assign
		StringBuilder b61888 = new StringBuilder(a61888);  // stick in stringbuilder
		b61888.append(" SafeStuff"); // append some safe content
		b61888.replace(b61888.length()-"Chars".length(),b61888.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61888 = new java.util.HashMap<String,Object>();
		map61888.put("key61888", b61888.toString()); // put in a collection
		String c61888 = (String)map61888.get("key61888"); // get it back out
		String d61888 = c61888.substring(0,c61888.length()-1); // extract most of it
		String e61888 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61888.getBytes() ) )); // B64 encode and decode it
		String f61888 = e61888.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g61888 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61888); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
