/**
* OWASP Benchmark Project v1.2
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

@WebServlet(value="/sqli-02/BenchmarkTest01007")
public class BenchmarkTest01007 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		javax.servlet.http.Cookie userCookie = new javax.servlet.http.Cookie("BenchmarkTest01007", "bar");
		userCookie.setMaxAge(60*3); //Store cookie for 3 minutes
		userCookie.setSecure(true);
		userCookie.setPath(request.getRequestURI());
		response.addCookie(userCookie);
		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/sqli-02/BenchmarkTest01007.html");
		rd.include(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = "noCookieValueSupplied";
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("BenchmarkTest01007")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					break;
				}
			}
		}

		String bar = new Test().doSomething(request, param);
		
		String sql = "SELECT TOP 1 userid from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
		try {
	        java.util.Map results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForMap(sql);
			response.getWriter().println(
				"Your results are: "
			);

	//		System.out.println("Your results are");
			response.getWriter().println(
				org.owasp.esapi.ESAPI.encoder().encodeForHTML(results.toString())
			);
	//		System.out.println(results.toString());
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			response.getWriter().println(
				"No results returned for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql)
			);
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println(
					"Error processing request."
				);
        	}
			else throw new ServletException(e);
		}
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar;
		String guess = "ABC";
		char switchTarget = guess.charAt(2);
		
		// Simple case statement that assigns param to bar on conditions 'A', 'C', or 'D'
		switch (switchTarget) {
		  case 'A':
		        bar = param;
		        break;
		  case 'B': 
		        bar = "bobs_your_uncle";
		        break;
		  case 'C':
		  case 'D':        
		        bar = param;
		        break;
		  default:
		        bar = "bobs_your_uncle";
		        break;
		}

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
