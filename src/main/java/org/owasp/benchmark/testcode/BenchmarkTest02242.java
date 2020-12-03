/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/cmdi-02/BenchmarkTest02242")
public class BenchmarkTest02242 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("BenchmarkTest02242");
			if (values != null) param = values[0];
		}
		

		String bar = doSomething(request, param);
		
		java.util.List<String> argList = new java.util.ArrayList<String>();
		
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	argList.add("cmd.exe");
        	argList.add("/c");
        } else {
        	argList.add("sh");
        	argList.add("-c");
        }
        argList.add("echo " + bar);

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(argList);
		
		try {
			Process p = pb.start();
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
            throw new ServletException(e);
		}
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91595 = param; //assign
		StringBuilder b91595 = new StringBuilder(a91595);  // stick in stringbuilder
		b91595.append(" SafeStuff"); // append some safe content
		b91595.replace(b91595.length()-"Chars".length(),b91595.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91595 = new java.util.HashMap<String,Object>();
		map91595.put("key91595", b91595.toString()); // put in a collection
		String c91595 = (String)map91595.get("key91595"); // get it back out
		String d91595 = c91595.substring(0,c91595.length()-1); // extract most of it
		String e91595 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d91595.getBytes() ) )); // B64 encode and decode it
		String f91595 = e91595.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g91595 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91595); // reflection
	
		return bar;	
	}
}
