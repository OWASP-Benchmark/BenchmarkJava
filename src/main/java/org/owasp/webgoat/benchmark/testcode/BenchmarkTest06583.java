package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06583")
public class BenchmarkTest06583 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map18050 = new java.util.HashMap<String,Object>();
		map18050.put("keyA-18050", "a_Value"); // put some stuff in the collection
		map18050.put("keyB-18050", param.toString()); // put it in a collection
		map18050.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map18050.get("keyB-18050"); // get it back out
		bar = (String)map18050.get("keyA-18050"); // get safe value back out
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
