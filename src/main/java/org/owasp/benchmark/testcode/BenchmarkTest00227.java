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

@WebServlet("/BenchmarkTest00227")
public class BenchmarkTest00227 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();
			java.util.Enumeration<String> values = request.getHeaders(name);
			if (values != null) {
				while (values.hasMoreElements() && flag) {
					String value = (String) values.nextElement();
					if (value.equals("vector")) {
						param = name;
						flag = false;
					}
				}
			}
		}
		
		
		// Chain a bunch of propagators in sequence
		String a43929 = param; //assign
		StringBuilder b43929 = new StringBuilder(a43929);  // stick in stringbuilder
		b43929.append(" SafeStuff"); // append some safe content
		b43929.replace(b43929.length()-"Chars".length(),b43929.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43929 = new java.util.HashMap<String,Object>();
		map43929.put("key43929", b43929.toString()); // put in a collection
		String c43929 = (String)map43929.get("key43929"); // get it back out
		String d43929 = c43929.substring(0,c43929.length()-1); // extract most of it
		String e43929 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43929.getBytes() ) )); // B64 encode and decode it
		String f43929 = e43929.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g43929 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43929); // reflection
		
		
		try {
		    java.util.Properties benchmarkprops = new java.util.Properties();
		    benchmarkprops.load(this.getClass().getClassLoader().getResourceAsStream("benchmark.properties"));
			String algorithm = benchmarkprops.getProperty("hashAlg1", "SHA512");
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
			byte[] input = { (byte)'?' };
			Object inputParam = bar;
			if (inputParam instanceof String) input = ((String) inputParam).getBytes();
			if (inputParam instanceof java.io.InputStream) {
				byte[] strInput = new byte[1000];
				int i = ((java.io.InputStream) inputParam).read(strInput);
				if (i == -1) {
					response.getWriter().println("This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
					return;
				}
				input = java.util.Arrays.copyOf(strInput, i);
			}			
			md.update(input);
			
			byte[] result = md.digest();
			java.io.File fileTarget = new java.io.File(
					new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir),"passwordFile.txt");
			java.io.FileWriter fw = new java.io.FileWriter(fileTarget,true); //the true will append the new data
			    fw.write("hash_value=" + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true) + "\n");
			fw.close();
			response.getWriter().println("Sensitive value '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(input)) + "' hashed and stored<br/>");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}
}
