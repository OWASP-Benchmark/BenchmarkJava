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

@WebServlet("/BenchmarkTest14898")
public class BenchmarkTest14898 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		// Create the file first so the test won't throw an exception if it doesn't exist.
		// Note: Don't actually do this because this method signature could cause a tool to find THIS file constructor 
		// as a vuln, rather than the File signature we are trying to actually test.
		// If necessary, just run the benchmark twice. The 1st run should create all the necessary files.
		//new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar).createNewFile();
		


        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
        		org.owasp.benchmark.helpers.Utils.testfileDir + bar);
        java.io.FileDescriptor fd = fileInputStream.getFD();
        java.io.FileOutputStream anotOutputStream = new java.io.FileOutputStream(fd);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4758 = param; //assign
		StringBuilder b4758 = new StringBuilder(a4758);  // stick in stringbuilder
		b4758.append(" SafeStuff"); // append some safe content
		b4758.replace(b4758.length()-"Chars".length(),b4758.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4758 = new java.util.HashMap<String,Object>();
		map4758.put("key4758", b4758.toString()); // put in a collection
		String c4758 = (String)map4758.get("key4758"); // get it back out
		String d4758 = c4758.substring(0,c4758.length()-1); // extract most of it
		String e4758 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4758.getBytes() ) )); // B64 encode and decode it
		String f4758 = e4758.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g4758 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g4758); // reflection
	
		return bar;	
	}
}
