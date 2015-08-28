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

@WebServlet("/BenchmarkTest01159")
public class BenchmarkTest01159 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("vector");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String fileName = null;
		java.io.FileInputStream fis = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.testfileDir + bar;
			fis = new java.io.FileInputStream(fileName);
			byte[] b = new byte[1000];
			int size = fis.read(b);
			response.getWriter().write("The beginning of file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName) + "' is:\n\n");
			response.getWriter().write(org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(b,0,size)));
		} catch (Exception e) {
			System.out.println("Couldn't open FileInputStream on file: '" + fileName + "'");
//			System.out.println("File exception caught and swallowed: " + e.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
                    fis = null;
				} catch (Exception e) {
					// we tried...
				}
			}
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36698 = param; //assign
		StringBuilder b36698 = new StringBuilder(a36698);  // stick in stringbuilder
		b36698.append(" SafeStuff"); // append some safe content
		b36698.replace(b36698.length()-"Chars".length(),b36698.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36698 = new java.util.HashMap<String,Object>();
		map36698.put("key36698", b36698.toString()); // put in a collection
		String c36698 = (String)map36698.get("key36698"); // get it back out
		String d36698 = c36698.substring(0,c36698.length()-1); // extract most of it
		String e36698 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36698.getBytes() ) )); // B64 encode and decode it
		String f36698 = e36698.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g36698 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g36698); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
