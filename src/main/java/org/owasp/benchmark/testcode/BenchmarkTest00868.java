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

@WebServlet(value="/hash-01/BenchmarkTest00868")
public class BenchmarkTest00868 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("BenchmarkTest00868");
		
		
		// Chain a bunch of propagators in sequence
		String a51118 = param; //assign
		StringBuilder b51118 = new StringBuilder(a51118);  // stick in stringbuilder
		b51118.append(" SafeStuff"); // append some safe content
		b51118.replace(b51118.length()-"Chars".length(),b51118.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51118 = new java.util.HashMap<String,Object>();
		map51118.put("key51118", b51118.toString()); // put in a collection
		String c51118 = (String)map51118.get("key51118"); // get it back out
		String d51118 = c51118.substring(0,c51118.length()-1); // extract most of it
		String e51118 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d51118.getBytes() ) )); // B64 encode and decode it
		String f51118 = e51118.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51118); // reflection
		
		
		java.security.Provider[] provider = java.security.Security.getProviders();
		java.security.MessageDigest md;

		try {
			if (provider.length > 1) {

				md = java.security.MessageDigest.getInstance("SHA1", provider[0]);
			} else {
				md = java.security.MessageDigest.getInstance("SHA1", "SUN");
			}
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
			md.update(input);
			
			byte[] result = md.digest();
			java.io.File fileTarget = new java.io.File(
					new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR),"passwordFile.txt");
			java.io.FileWriter fw = new java.io.FileWriter(fileTarget,true); //the true will append the new data
			    fw.write("hash_value=" + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true) + "\n");
			fw.close();
			response.getWriter().println(
"Sensitive value '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(input)) + "' hashed and stored<br/>"
);

		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider)");
            throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider)");
            throw new ServletException(e);
		}

		response.getWriter().println(
"Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider) executed"
);
	}
	
}
