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

@WebServlet("/BenchmarkTest11747")
public class BenchmarkTest11747 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77506 = param; //assign
		StringBuilder b77506 = new StringBuilder(a77506);  // stick in stringbuilder
		b77506.append(" SafeStuff"); // append some safe content
		b77506.replace(b77506.length()-"Chars".length(),b77506.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77506 = new java.util.HashMap<String,Object>();
		map77506.put("key77506", b77506.toString()); // put in a collection
		String c77506 = (String)map77506.get("key77506"); // get it back out
		String d77506 = c77506.substring(0,c77506.length()-1); // extract most of it
		String e77506 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77506.getBytes() ) )); // B64 encode and decode it
		String f77506 = e77506.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77506); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
