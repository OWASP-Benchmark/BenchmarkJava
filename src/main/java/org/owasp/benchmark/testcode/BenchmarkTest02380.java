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

@WebServlet(value="/pathtraver-02/BenchmarkTest02380")
public class BenchmarkTest02380 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("BenchmarkTest02380");
		if (param == null) param = "";

		String bar = doSomething(request, param);
		
		String fileName = null;
		java.io.FileOutputStream fos = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;
	
			fos = new java.io.FileOutputStream(new java.io.File(fileName));
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
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76789 = param; //assign
		StringBuilder b76789 = new StringBuilder(a76789);  // stick in stringbuilder
		b76789.append(" SafeStuff"); // append some safe content
		b76789.replace(b76789.length()-"Chars".length(),b76789.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76789 = new java.util.HashMap<String,Object>();
		map76789.put("key76789", b76789.toString()); // put in a collection
		String c76789 = (String)map76789.get("key76789"); // get it back out
		String d76789 = c76789.substring(0,c76789.length()-1); // extract most of it
		String e76789 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d76789.getBytes() ) )); // B64 encode and decode it
		String f76789 = e76789.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g76789 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76789); // reflection
	
		return bar;	
	}
}
