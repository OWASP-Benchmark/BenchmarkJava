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
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/pathtraver-01/BenchmarkTest01159")
public class BenchmarkTest01159 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest01159");
		
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		// URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = new Test().doSomething(request, param);
		
		String fileName = null;
		java.io.FileInputStream fis = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;
			fis = new java.io.FileInputStream(fileName);
			byte[] b = new byte[1000];
			int size = fis.read(b);
			response.getWriter().println(
"The beginning of file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName) + "' is:\n\n"
);
			response.getWriter().println(
org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(b,0,size))
);
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

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a54259 = param; //assign
		StringBuilder b54259 = new StringBuilder(a54259);  // stick in stringbuilder
		b54259.append(" SafeStuff"); // append some safe content
		b54259.replace(b54259.length()-"Chars".length(),b54259.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54259 = new java.util.HashMap<String,Object>();
		map54259.put("key54259", b54259.toString()); // put in a collection
		String c54259 = (String)map54259.get("key54259"); // get it back out
		String d54259 = c54259.substring(0,c54259.length()-1); // extract most of it
		String e54259 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d54259.getBytes() ) )); // B64 encode and decode it
		String f54259 = e54259.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g54259 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g54259); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
