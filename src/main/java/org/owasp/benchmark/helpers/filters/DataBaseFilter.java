package org.owasp.benchmark.helpers.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DataBaseFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	/**
	 * Filter to roll back after every test.
	 **/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		filterChain.doFilter(request, response);

		try {
			org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection().rollback();
		} catch (SQLException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
				response.getWriter().println("Problem while rolling back!");
				return;
			} else
				throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {
	}

}
