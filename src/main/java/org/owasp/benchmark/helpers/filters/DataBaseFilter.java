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
	protected FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
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
				System.out.println("Problem while rolling back the database");
				return;
			} else
				throw new ServletException(e);
		}

	}

	@Override
	public void destroy() {
	}

}
