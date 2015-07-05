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

@WebServlet("/BenchmarkTest02676")
public class BenchmarkTest02676 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map37040 = new java.util.HashMap<String,Object>();
		map37040.put("keyA-37040", "a_Value"); // put some stuff in the collection
		map37040.put("keyB-37040", param.toString()); // put it in a collection
		map37040.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map37040.get("keyB-37040"); // get it back out
		bar = (String)map37040.get("keyA-37040"); // get safe value back out
		
		
		try {
			java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	double rand = getNextNumber(numGen);
			
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextDouble() - TestCase");
			throw new ServletException(e);
	    }
		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextDouble() executed");
	}
		double getNextNumber(java.util.Random generator) {
			return generator.nextDouble();
	}
}
