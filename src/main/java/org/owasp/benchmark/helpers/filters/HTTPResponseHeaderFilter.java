package org.owasp.benchmark.helpers.filters;
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
* @created 2020
*/

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class HTTPResponseHeaderFilter implements Filter {
	protected FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	/**
	 * Filter to add additional security headers to every response.
	 **/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		if (response instanceof HttpServletResponse) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			// Note that setHeader overwrites any existing header already set with the same name.
			// The 'unsafe-eval' value was added because Chrome would block XSS attacks via Referers with the error:
			// Uncaught EvalError: Refused to evaluate a string as JavaScript because 'unsafe-eval' is not an allowed
			// source of script in the following Content Security Policy directive: "default-src 'unsafe-inline' 'self'".
			httpResponse.setHeader("Content-Security-Policy", "frame-ancestors 'self'; form-action 'self'; " +
				"default-src 'unsafe-inline' 'unsafe-eval' 'self'; style-src 'unsafe-inline' 'self'; style-src-elem 'self' fonts.googleapis.com; " +
				"font-src 'self' fonts.gstatic.com");
			// The proper setting for this header is 'private' but DAST tools still complain about it, so
			// setting it this way even though the app will be slightly slower.
			httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
