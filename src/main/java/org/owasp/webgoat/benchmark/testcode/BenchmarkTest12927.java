/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
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

@WebServlet("/BenchmarkTest12927")
public class BenchmarkTest12927 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14809 = param; //assign
		StringBuilder b14809 = new StringBuilder(a14809);  // stick in stringbuilder
		b14809.append(" SafeStuff"); // append some safe content
		b14809.replace(b14809.length()-"Chars".length(),b14809.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14809 = new java.util.HashMap<String,Object>();
		map14809.put("key14809", b14809.toString()); // put in a collection
		String c14809 = (String)map14809.get("key14809"); // get it back out
		String d14809 = c14809.substring(0,c14809.length()-1); // extract most of it
		String e14809 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14809.getBytes() ) )); // B64 encode and decode it
		String f14809 = e14809.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14809); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
