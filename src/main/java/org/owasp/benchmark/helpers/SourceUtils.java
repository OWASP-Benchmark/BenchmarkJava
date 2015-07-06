/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SourceUtils {

	public static final String USERDIR = System.getProperty("user.dir");

	public static String getCookie( HttpServletRequest request, String paramName ) {
		Cookie[] values = request.getCookies();
		String param = "none";
		if (paramName != null) {
			int i = 0;
			while (i < values.length)
			{
				if (values[i].getName().equals(paramName)) {
					param = values[i].getValue();
					break;
				}
				i++;
			}
		}
		return param;
	}
	
	public static String getParam( HttpServletRequest request, String paramName ) {
		String param = request.getParameter(paramName);
		return param;
	}
}
