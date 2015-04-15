package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19688")
public class BenchmarkTest19688 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

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
		String a47054 = param; //assign
		StringBuilder b47054 = new StringBuilder(a47054);  // stick in stringbuilder
		b47054.append(" SafeStuff"); // append some safe content
		b47054.replace(b47054.length()-"Chars".length(),b47054.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47054 = new java.util.HashMap<String,Object>();
		map47054.put("key47054", b47054.toString()); // put in a collection
		String c47054 = (String)map47054.get("key47054"); // get it back out
		String d47054 = c47054.substring(0,c47054.length()-1); // extract most of it
		String e47054 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47054.getBytes() ) )); // B64 encode and decode it
		String f47054 = e47054.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47054); // reflection
	
		return bar;	
	}
}
