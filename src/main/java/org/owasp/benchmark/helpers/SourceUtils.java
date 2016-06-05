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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
	
	public static List<String> getLinesFromFile(String f) {

		File file = new File(f);

		if (!file.exists()) {
			System.out.println("Can't find file to get lines from: " + f);
			return null;
		}

		FileReader fr = null;
		BufferedReader br = null;

		List<String> sourceLines = new ArrayList<String>();

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				sourceLines.add(line);
			}
		} catch (Exception e) {
			//
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (Exception ex) {
			}
		}

		return sourceLines;
	}
}
