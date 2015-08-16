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

@WebServlet("/BenchmarkTest01953")
public class BenchmarkTest01953 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String param = request.getHeader("vector");
		if (param == null) param = "";

		String bar = doSomething(param);
		
		String fileName = org.owasp.benchmark.helpers.Utils.testfileDir + bar;
        java.io.InputStream is = null;
        
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(fileName);
			is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
			byte[] b = new byte[1000];
			int size = is.read(b);
			response.getWriter().write("The beginning of file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName) + "' is:\n\n");
			response.getWriter().write(org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(b,0,size)));
			is.close();
		} catch (Exception e) {
            System.out.println("Couldn't open InputStream on file: '" + fileName + "'");
			response.getWriter().write("Problem getting InputStream: " + e.getMessage());
        } finally {
			if (is != null) {
                try {
                    is.close();
                    is = null;
                } catch (Exception e) {
                    // we tried...
                }
            }
        }
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11513 = param; //assign
		StringBuilder b11513 = new StringBuilder(a11513);  // stick in stringbuilder
		b11513.append(" SafeStuff"); // append some safe content
		b11513.replace(b11513.length()-"Chars".length(),b11513.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11513 = new java.util.HashMap<String,Object>();
		map11513.put("key11513", b11513.toString()); // put in a collection
		String c11513 = (String)map11513.get("key11513"); // get it back out
		String d11513 = c11513.substring(0,c11513.length()-1); // extract most of it
		String e11513 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11513.getBytes() ) )); // B64 encode and decode it
		String f11513 = e11513.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g11513 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11513); // reflection
	
		return bar;	
	}
}
