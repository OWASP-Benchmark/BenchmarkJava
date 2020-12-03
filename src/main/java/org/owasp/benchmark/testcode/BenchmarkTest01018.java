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

@WebServlet(value="/crypto-01/BenchmarkTest01018")
public class BenchmarkTest01018 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		if (request.getHeader("BenchmarkTest01018") != null) {
			param = request.getHeader("BenchmarkTest01018");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = new Test().doSomething(request, param);
		
		// Code based on example from:
		// http://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-file-stream-with-des/
	    // 8-byte initialization vector
//	    byte[] iv = {
//	    	(byte)0xB2, (byte)0x12, (byte)0xD5, (byte)0xB2,
//	    	(byte)0x44, (byte)0x21, (byte)0xC3, (byte)0xC3033
//	    };
	    java.security.SecureRandom random = new java.security.SecureRandom();
		byte[] iv = random.generateSeed(8); // DES requires 8 byte keys
		
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
			
            // Prepare the cipher to encrypt
            javax.crypto.SecretKey key = javax.crypto.KeyGenerator.getInstance("DES").generateKey();
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
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
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
		} catch (java.security.InvalidKeyException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case"
);
e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.InvalidAlgorithmParameterException e) {
			response.getWriter().println(
"Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case"
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

		String bar = org.springframework.web.util.HtmlUtils.htmlEscape(param);

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
