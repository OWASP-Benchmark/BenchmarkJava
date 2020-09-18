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
* @author Juan GaMa
* @created 2015
*/

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StatusCodeResponseWrapper extends HttpServletResponseWrapper {

	private int httpStatus = SC_FORBIDDEN;
	protected CharArrayWriter charWriter;

	protected PrintWriter writer;

	protected boolean getOutputStreamCalled;

	protected boolean getWriterCalled;

	public StatusCodeResponseWrapper(HttpServletResponse response) {
		super(response);
		charWriter = new CharArrayWriter();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (getWriterCalled) {
			throw new IllegalStateException("getWriter already called");
		}

		getOutputStreamCalled = true;
		return super.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return writer;
		}
		if (getOutputStreamCalled) {
			throw new IllegalStateException("getOutputStream already called");
		}
		getWriterCalled = true;
		writer = new PrintWriter(charWriter);
		return writer;
	}

	@Override
	public void sendError(int sc) throws IOException {
		httpStatus = sc;
		System.out.println("Inside wrapper: " + sc);
		super.sendError(sc);
	}

	@Override
	public void sendError(int sc, String msg) throws IOException {
		httpStatus = sc;
		super.sendError(sc, msg);
	}

	@Override
	public void setStatus(int sc) {
		httpStatus = sc;
		super.setStatus(sc);
	}

	public int getStatus() {
		return httpStatus;
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		httpStatus = SC_MOVED_TEMPORARILY;
		super.sendRedirect(location);
	}

	public String toString() {
		String s = null;

		if (writer != null) {
			s = charWriter.toString();
		}
		return s;
	}
}
