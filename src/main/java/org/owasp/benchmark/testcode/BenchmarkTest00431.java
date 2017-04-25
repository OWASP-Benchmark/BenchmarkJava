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

@WebServlet(value="/sqli-00/BenchmarkTest00431")
public class BenchmarkTest00431 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00431");
		if (param == null) param = "";
		
		
		String bar;
		
		// Simple ? condition that assigns param to bar on false condition
		int num = 106;
		
		bar = (7*42) - num > 200 ? "This should never happen" : param;
		
		
		
 		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
 		try {
			java.util.List<String> results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.query(sql,  new org.springframework.jdbc.core.RowMapper<String>() {
	            public String mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
	                try {
	                	return rs.getString("USERNAME");
	                } catch (java.sql.SQLException e) {
	                	if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
	        				return "Error processing query.";
	        			}
						else throw e;
					}
	            }
	        });
			response.getWriter().println(
				"Your results are: "
			);

	//		System.out.println("Your results are");
			for (String s : results) {
				response.getWriter().println(
					org.owasp.esapi.ESAPI.encoder().encodeForHTML(s) + "<br>"
				);
	//			System.out.println(s);
			}
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
	}
	
}
