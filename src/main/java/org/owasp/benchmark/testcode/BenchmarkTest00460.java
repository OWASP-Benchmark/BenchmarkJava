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

@WebServlet("/BenchmarkTest00460")
public class BenchmarkTest00460 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("vector");
			if (values != null) param = values[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a5952 = param; //assign
		StringBuilder b5952 = new StringBuilder(a5952);  // stick in stringbuilder
		b5952.append(" SafeStuff"); // append some safe content
		b5952.replace(b5952.length()-"Chars".length(),b5952.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5952 = new java.util.HashMap<String,Object>();
		map5952.put("key5952", b5952.toString()); // put in a collection
		String c5952 = (String)map5952.get("key5952"); // get it back out
		String d5952 = c5952.substring(0,c5952.length()-1); // extract most of it
		String e5952 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5952.getBytes() ) )); // B64 encode and decode it
		String f5952 = e5952.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g5952 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5952); // reflection
		
		
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
			response.getWriter().write("Problem getting InputStream: " 
				+ org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
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
	}
}
