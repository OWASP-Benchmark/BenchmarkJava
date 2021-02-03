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

@WebServlet(value="/pathtraver-00/BenchmarkTest00628")
public class BenchmarkTest00628 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("BenchmarkTest00628");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a24315 = param; //assign
		StringBuilder b24315 = new StringBuilder(a24315);  // stick in stringbuilder
		b24315.append(" SafeStuff"); // append some safe content
		b24315.replace(b24315.length()-"Chars".length(),b24315.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24315 = new java.util.HashMap<String,Object>();
		map24315.put("key24315", b24315.toString()); // put in a collection
		String c24315 = (String)map24315.get("key24315"); // get it back out
		String d24315 = c24315.substring(0,c24315.length()-1); // extract most of it
		String e24315 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d24315.getBytes() ) )); // B64 encode and decode it
		String f24315 = e24315.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g24315 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g24315); // reflection
		
		
		String fileName = null;
		java.io.FileOutputStream fos = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;
	
			fos = new java.io.FileOutputStream(fileName);
	        response.getWriter().println(
			"Now ready to write to file: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName)
);

   		} catch (Exception e) {
			System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
//			System.out.println("File exception caught and swallowed: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
                    fos = null;
				} catch (Exception e) {
					// we tried...
				}
			}
		}
	}
	
}
