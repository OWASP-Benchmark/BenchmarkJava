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

@WebServlet("/BenchmarkTest02153")
public class BenchmarkTest02153 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String param = request.getParameter("vector");
		if (param == null) param = "";

		String bar = doSomething(param);
		
		String cmd = org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(this.getClass().getClassLoader());
		String[] args = {cmd};
        String[] argsEnv = { bar };
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29792 = param; //assign
		StringBuilder b29792 = new StringBuilder(a29792);  // stick in stringbuilder
		b29792.append(" SafeStuff"); // append some safe content
		b29792.replace(b29792.length()-"Chars".length(),b29792.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29792 = new java.util.HashMap<String,Object>();
		map29792.put("key29792", b29792.toString()); // put in a collection
		String c29792 = (String)map29792.get("key29792"); // get it back out
		String d29792 = c29792.substring(0,c29792.length()-1); // extract most of it
		String e29792 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29792.getBytes() ) )); // B64 encode and decode it
		String f29792 = e29792.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g29792 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g29792); // reflection
	
		return bar;	
	}
}
