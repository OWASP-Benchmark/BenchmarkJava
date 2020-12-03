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
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/crypto-01/BenchmarkTest01227")
public class BenchmarkTest01227 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest01227");
		if (param == null) param = "";

		String bar = new Test().doSomething(request, param);
		
		// Code based on example from:
		// http://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-file-stream-with-des/
		// AES/GCM example from: https://javainterviewpoint.com/java-aes-256-gcm-encryption-and-decryption/
	    // 16-byte initialization vector
//	    byte[] iv = {
//	    	(byte)0xB2, (byte)0x12, (byte)0xD5, (byte)0xB2,
//	    	(byte)0x44, (byte)0x21, (byte)0xC3, (byte)0xC3,
//	    	(byte)0xF3, (byte)0x3C, (byte)0x23, (byte)0xB9,
//	    	(byte)0x9E, (byte)0xC5, (byte)0x77, (byte)0x0B033
//	    };
	    java.security.SecureRandom random = new java.security.SecureRandom();
		byte[] iv = random.generateSeed(16);
	    
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/GCM/NOPADDING");

			// Prepare the cipher to encrypt
			javax.crypto.SecretKey key = javax.crypto.KeyGenerator.getInstance("AES").generateKey();
			javax.crypto.spec.GCMParameterSpec paramSpec = new javax.crypto.spec.GCMParameterSpec(16 * 8, iv);
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key, paramSpec);

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

			
		} catch (java.security.NoSuchAlgorithmException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.IllegalBlockSizeException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.BadPaddingException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.InvalidKeyException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.InvalidAlgorithmParameterException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		}
		response.getWriter().println(
"Crypto Test javax.crypto.Cipher.getInstance(java.lang.String) executed"
);

	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar = param;
		if (param != null && param.length() > 1) {
		    StringBuilder sbxyz39213 = new StringBuilder(param);
		    bar = sbxyz39213.replace(param.length()-"Z".length(), param.length(),"Z").toString();
		}

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
