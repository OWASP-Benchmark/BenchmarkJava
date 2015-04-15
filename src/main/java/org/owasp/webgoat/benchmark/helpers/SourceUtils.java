package org.owasp.webgoat.benchmark.helpers;

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
