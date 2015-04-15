package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17818")
public class BenchmarkTest17818 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93979 = param; //assign
		StringBuilder b93979 = new StringBuilder(a93979);  // stick in stringbuilder
		b93979.append(" SafeStuff"); // append some safe content
		b93979.replace(b93979.length()-"Chars".length(),b93979.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93979 = new java.util.HashMap<String,Object>();
		map93979.put("key93979", b93979.toString()); // put in a collection
		String c93979 = (String)map93979.get("key93979"); // get it back out
		String d93979 = c93979.substring(0,c93979.length()-1); // extract most of it
		String e93979 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93979.getBytes() ) )); // B64 encode and decode it
		String f93979 = e93979.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93979); // reflection
	
		return bar;	
	}
}
