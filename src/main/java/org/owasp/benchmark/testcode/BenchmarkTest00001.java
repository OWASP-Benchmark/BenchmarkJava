/**
* OWASP Benchmark v1.2
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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/pathtraver-00/BenchmarkTest00001")
public class BenchmarkTest00001 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		javax.servlet.http.Cookie userCookie = new javax.servlet.http.Cookie("BenchmarkTest00001", "FileName");
		userCookie.setMaxAge(60*3); //Store cookie for 3 minutes
		userCookie.setSecure(true);
		userCookie.setPath(request.getRequestURI());
		response.addCookie(userCookie);
		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/pathtraver-00/BenchmarkTest00001.html");
		rd.include(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// some code
		response.setContentType("text/html;charset=UTF-8");
		

		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = "noCookieValueSupplied";
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("BenchmarkTest00001")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					break;
				}
			}
		}

		
        String fileName = null;
        java.io.FileInputStream fis = null;

        try {
          fileName = org.owasp.benchmark.helpers.Utils.testfileDir + param;
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
