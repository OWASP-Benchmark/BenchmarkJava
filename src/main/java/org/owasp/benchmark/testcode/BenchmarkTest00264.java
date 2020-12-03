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

@WebServlet(value="/pathtraver-00/BenchmarkTest00264")
public class BenchmarkTest00264 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00264");
		
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		// URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		String bar;
		
		// Simple if statement that assigns param to bar on true condition
		int num = 196;
		if ( (500/42) + num > 200 )
		   bar = param;
		else bar = "This should never happen"; 
		
		
        String fileName = null;
        java.io.FileInputStream fis = null;

        try {
          fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;
          fis = new java.io.FileInputStream(new java.io.File(fileName));
          byte[] b = new byte[1000];
          int size = fis.read(b);
          response.getWriter().println(
            "The beginning of file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName)
              + "' is:\n\n" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(b,0,size))
          );
        } catch (Exception e) {
            System.out.println("Couldn't open FileInputStream on file: '" + fileName + "'");
            response.getWriter().println(
              "Problem getting FileInputStream: "
                 + org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage())
            );
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    fis = null;
                } catch (Exception e) {
                    // we tried...
                }
            }
        }
	}
	
}
