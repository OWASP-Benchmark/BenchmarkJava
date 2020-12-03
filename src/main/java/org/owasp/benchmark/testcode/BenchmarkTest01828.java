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
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/crypto-02/BenchmarkTest01828")
public class BenchmarkTest01828 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		javax.servlet.http.Cookie userCookie = new javax.servlet.http.Cookie("BenchmarkTest01828", "someSecret");
		userCookie.setMaxAge(60*3); //Store cookie for 3 minutes
		userCookie.setSecure(true);
		userCookie.setPath(request.getRequestURI());
		userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
		response.addCookie(userCookie);
		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/crypto-02/BenchmarkTest01828.html");
		rd.include(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = "noCookieValueSupplied";
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("BenchmarkTest01828")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					break;
				}
			}
		}

		String bar = doSomething(request, param);
		
		// Code based on example from:
		// http://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-file-stream-with-des/

		try {
			javax.crypto.Cipher c = org.owasp.benchmark.helpers.Utils.getCipher();
			// encrypt and store the results
			byte[] input = { (byte)'?' };
			Object inputParam = bar;
			if (inputParam instanceof String) input = ((String) inputParam).getBytes();
			if (inputParam instanceof java.io.InputStream) {
				byte[] strInput = new byte[1000];
				int i = ((java.io.InputStream) inputParam).read(strInput);
				if (i == -1) {
					response.getWriter().println(
"This input source requires a POST, not a GET. Incompatible UI for the InputStream source."
);
					return;
				}
				input = java.util.Arrays.copyOf(strInput, i);
			}
			byte[] result = c.doFinal(input);
			
			java.io.File fileTarget = new java.io.File(
					new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR),"passwordFile.txt");
			java.io.FileWriter fw = new java.io.FileWriter(fileTarget,true); //the true will append the new data
			    fw.write("secret_value=" + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true) + "\n");
			fw.close();
			response.getWriter().println(
"Sensitive value: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(input)) + "' encrypted and stored<br/>"
);

		} catch (javax.crypto.IllegalBlockSizeException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.BadPaddingException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		}
		response.getWriter().println(
"Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) executed"
);
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		StringBuilder sbxyz6675 = new StringBuilder(param);
		String bar = sbxyz6675.append("_SafeStuff").toString();
	
		return bar;	
	}
}
