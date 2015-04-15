package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03912")
public class BenchmarkTest03912 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		java.util.List<String> valuesList = new java.util.ArrayList<String>( );
		valuesList.add("safe");
		valuesList.add( param );
		valuesList.add( "moresafe" );
		
		valuesList.remove(0); // remove the 1st safe value
		
		String bar = valuesList.get(1); // get the last 'safe' value
		
		
		
		response.getWriter().write(bar);
	}
}
