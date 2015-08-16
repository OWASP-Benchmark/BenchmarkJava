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

@WebServlet("/BenchmarkTest00225")
public class BenchmarkTest00225 extends HttpServlet {
	
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
		String a81436 = param; //assign
		StringBuilder b81436 = new StringBuilder(a81436);  // stick in stringbuilder
		b81436.append(" SafeStuff"); // append some safe content
		b81436.replace(b81436.length()-"Chars".length(),b81436.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81436 = new java.util.HashMap<String,Object>();
		map81436.put("key81436", b81436.toString()); // put in a collection
		String c81436 = (String)map81436.get("key81436"); // get it back out
		String d81436 = c81436.substring(0,c81436.length()-1); // extract most of it
		String e81436 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81436.getBytes() ) )); // B64 encode and decode it
		String f81436 = e81436.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g81436 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g81436); // reflection
		
		
		// Code based on example from:
		// http://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-file-stream-with-des/
	    // 16-byte initialization vector
	    byte[] iv = {
	    	(byte)0xB2, (byte)0x12, (byte)0xD5, (byte)0xB2,
	    	(byte)0x44, (byte)0x21, (byte)0xC3, (byte)0xC3,
	    	(byte)0xF3, (byte)0x3C, (byte)0x23, (byte)0xB9,
	    	(byte)0x9E, (byte)0xC5, (byte)0x77, (byte)0x0B033
	    };
	    
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING", java.security.Security.getProvider("SunJCE"));
            
            // Prepare the cipher to encrypt
            javax.crypto.SecretKey key = javax.crypto.KeyGenerator.getInstance("AES").generateKey();
            java.security.spec.AlgorithmParameterSpec paramSpec = new javax.crypto.spec.IvParameterSpec(iv);
            c.init(javax.crypto.Cipher.ENCRYPT_MODE, key, paramSpec);
			
			// encrypt and store the results
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
			byte[] result = c.doFinal(input);
			
			java.io.File fileTarget = new java.io.File(
					new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir),"passwordFile.txt");
			java.io.FileWriter fw = new java.io.FileWriter(fileTarget,true); //the true will append the new data
			    fw.write("secret_value=" + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true) + "\n");
			fw.close();
			response.getWriter().println("Sensitive value: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(input)) + "' encrypted and stored<br/>");
			
		} catch (java.security.NoSuchAlgorithmException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.IllegalBlockSizeException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.BadPaddingException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.InvalidKeyException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.InvalidAlgorithmParameterException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) executed");
	}
}
