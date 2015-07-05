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

@WebServlet("/BenchmarkTest06064")
public class BenchmarkTest06064 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a90203 = param; //assign
		StringBuilder b90203 = new StringBuilder(a90203);  // stick in stringbuilder
		b90203.append(" SafeStuff"); // append some safe content
		b90203.replace(b90203.length()-"Chars".length(),b90203.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90203 = new java.util.HashMap<String,Object>();
		map90203.put("key90203", b90203.toString()); // put in a collection
		String c90203 = (String)map90203.get("key90203"); // get it back out
		String d90203 = c90203.substring(0,c90203.length()-1); // extract most of it
		String e90203 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90203.getBytes() ) )); // B64 encode and decode it
		String f90203 = e90203.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90203); // reflection
		
		
		// Create the file first so the test won't throw an exception if it doesn't exist.
		// Note: Don't actually do this because this method signature could cause a tool to find THIS file constructor 
		// as a vuln, rather than the File signature we are trying to actually test.
		// If necessary, just run the benchmark twice. The 1st run should create all the necessary files.
		//new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar).createNewFile();
		


        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
        		org.owasp.benchmark.helpers.Utils.testfileDir + bar);
        java.io.FileDescriptor fd = fileInputStream.getFD();
        java.io.FileOutputStream anotOutputStream = new java.io.FileOutputStream(fd);
	}
}
