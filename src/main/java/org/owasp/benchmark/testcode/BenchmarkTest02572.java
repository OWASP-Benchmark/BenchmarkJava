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

@WebServlet("/BenchmarkTest02572")
public class BenchmarkTest02572 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String[] values = request.getParameterValues("vector");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = doSomething(param);
		
		String cmd = org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(this.getClass().getClassLoader());
		String[] args = {cmd};
        String[] argsEnv = { bar };
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args, argsEnv);
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92161 = param; //assign
		StringBuilder b92161 = new StringBuilder(a92161);  // stick in stringbuilder
		b92161.append(" SafeStuff"); // append some safe content
		b92161.replace(b92161.length()-"Chars".length(),b92161.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92161 = new java.util.HashMap<String,Object>();
		map92161.put("key92161", b92161.toString()); // put in a collection
		String c92161 = (String)map92161.get("key92161"); // get it back out
		String d92161 = c92161.substring(0,c92161.length()-1); // extract most of it
		String e92161 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92161.getBytes() ) )); // B64 encode and decode it
		String f92161 = e92161.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g92161 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92161); // reflection
	
		return bar;	
	}
}
