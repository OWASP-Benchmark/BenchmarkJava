/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SeparateClassRequest {
	private HttpServletRequest request;
	

	public SeparateClassRequest( HttpServletRequest request ) {
		this.request = request;
	}
	
	public String getTheParameter(String p) {
		return request.getParameter(p);
	}
	
	public String getTheCookie(String c) {
		Cookie[] cookies = request.getCookies();
		
		String value = "";
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(c)) {
					value = cookie.getValue();
					break;
				}
			}
		} 
		
		return value;
	}
	
	// This method is a 'safe' source.
	public String getTheValue(String p) {
		return "bar";
	}
	
}
