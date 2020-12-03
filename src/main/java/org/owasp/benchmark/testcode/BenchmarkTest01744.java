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

@WebServlet(value="/pathtraver-02/BenchmarkTest01744")
public class BenchmarkTest01744 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("BenchmarkTest01744");

		String bar = new Test().doSomething(request, param);
		
		java.io.File fileTarget = new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR, bar);
		response.getWriter().println(
"Access to file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileTarget.toString()) + "' created." 
);
		if (fileTarget.exists()) {
			response.getWriter().println(
" And file already exists."
);
		} else { response.getWriter().println(
" But file doesn't exist yet."
); }
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a17402 = param; //assign
		StringBuilder b17402 = new StringBuilder(a17402);  // stick in stringbuilder
		b17402.append(" SafeStuff"); // append some safe content
		b17402.replace(b17402.length()-"Chars".length(),b17402.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17402 = new java.util.HashMap<String,Object>();
		map17402.put("key17402", b17402.toString()); // put in a collection
		String c17402 = (String)map17402.get("key17402"); // get it back out
		String d17402 = c17402.substring(0,c17402.length()-1); // extract most of it
		String e17402 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d17402.getBytes() ) )); // B64 encode and decode it
		String f17402 = e17402.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g17402 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g17402); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
