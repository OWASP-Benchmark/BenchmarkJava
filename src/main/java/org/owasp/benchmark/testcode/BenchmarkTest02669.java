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
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02669")
public class BenchmarkTest02669 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String queryString = request.getQueryString();
		String paramval = "vector"+"=";
		int paramLoc = -1;
		if (queryString != null) paramLoc = queryString.indexOf(paramval);
		if (paramLoc == -1) {
			response.getWriter().println("getQueryString() couldn't find expected parameter '" + "vector" + "' in query string.");
			return;
		}
		
		String param = queryString.substring(paramLoc + paramval.length()); // 1st assume "vector" param is last parameter in query string.
		// And then check to see if its in the middle of the query string and if so, trim off what comes after.
		int ampersandLoc = queryString.indexOf("&", paramLoc);
		if (ampersandLoc != -1) {
			param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
		}
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = doSomething(param);
		
		String cmd = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        }
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91413 = param; //assign
		StringBuilder b91413 = new StringBuilder(a91413);  // stick in stringbuilder
		b91413.append(" SafeStuff"); // append some safe content
		b91413.replace(b91413.length()-"Chars".length(),b91413.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91413 = new java.util.HashMap<String,Object>();
		map91413.put("key91413", b91413.toString()); // put in a collection
		String c91413 = (String)map91413.get("key91413"); // get it back out
		String d91413 = c91413.substring(0,c91413.length()-1); // extract most of it
		String e91413 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91413.getBytes() ) )); // B64 encode and decode it
		String f91413 = e91413.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g91413 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91413); // reflection
	
		return bar;	
	}
}
