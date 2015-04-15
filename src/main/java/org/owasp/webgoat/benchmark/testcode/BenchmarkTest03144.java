package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03144")
public class BenchmarkTest03144 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = param;
		if (param.length() > 1) {
		    StringBuilder sbxyz57621 = new StringBuilder(param);
		    bar = sbxyz57621.replace(param.length()-"Z".length(), param.length(),"Z").toString();
		}
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
