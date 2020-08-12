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
import java.sql.SQLException;

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

		filterChain.doFilter(request, response);
		
		if (response instanceof HttpServletResponse) {
			HttpServletResponse httpresponse = (HttpServletResponse) response;
//			httpresponse.addHeader("Cache-Control", "private"); // The proper setting but don't bother
			httpresponse.addHeader("Content-Security-Policy", "frame-ancestors 'self'; default-src 'self'; form-action 'self'");
		}
	}

	@Override
	public void destroy() {
	}

}
