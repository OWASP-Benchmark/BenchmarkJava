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
* @author Juan GaMa
* @created 2015
*/

package org.owasp.benchmark.helpers.filters;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.benchmark.helpers.PropertiesManager;
import org.owasp.benchmark.helpers.Utils;
import org.owasp.benchmark.score.BenchmarkScore;

public class StatusCodeResponseFilter implements Filter {
	protected FilterConfig config;
	private static final String STATUSCODE_PATH_FILE = Utils.DATA_DIR + "crawlerStatusCodes.txt";
	private static final String TESTCASENAME = new PropertiesManager().getProperty("testsuite", "Benchmark")
			+ BenchmarkScore.TEST;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletResponse newResponse = response;
		if (request instanceof HttpServletRequest) {
			newResponse = new StatusCodeResponseWrapper((HttpServletResponse) response);
		}

		chain.doFilter(request, newResponse);
		StatusCodeResponseWrapper hsr = (StatusCodeResponseWrapper) newResponse;
		// System.out.println("HTTP Status filter: " + hsr.getStatus());
		String text = hsr.toString();
		if (text != null) {
			text = text + "<head><meta id='web_response' name='response' content='" + hsr.getStatus() + "'/>";
			response.getWriter().write(text);
		} else {
			HttpServletRequest req = (HttpServletRequest) request;
			if (req.getRequestURL().toString().contains(TESTCASENAME)) {
				String line = req.getRequestURL() + "," + hsr.getStatus();
				// System.out.println("Line to write: " + line);
				Utils.writeLineToFile(Paths.get(Utils.DATA_DIR), STATUSCODE_PATH_FILE, line);
			}
			// System.out.println("empty response");
		}

	}

	@Override
	public void destroy() {
	}
}
