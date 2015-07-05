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

@WebServlet("/BenchmarkTest17926")
public class BenchmarkTest17926 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		}

		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map28160 = new java.util.HashMap<String,Object>();
		map28160.put("keyA-28160", "a_Value"); // put some stuff in the collection
		map28160.put("keyB-28160", param.toString()); // put it in a collection
		map28160.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map28160.get("keyB-28160"); // get it back out
		bar = (String)map28160.get("keyA-28160"); // get safe value back out
	
		return bar;	
	}
}
