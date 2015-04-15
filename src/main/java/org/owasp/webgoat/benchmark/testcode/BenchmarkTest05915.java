package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05915")
public class BenchmarkTest05915 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a5946 = param; //assign
		StringBuilder b5946 = new StringBuilder(a5946);  // stick in stringbuilder
		b5946.append(" SafeStuff"); // append some safe content
		b5946.replace(b5946.length()-"Chars".length(),b5946.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5946 = new java.util.HashMap<String,Object>();
		map5946.put("key5946", b5946.toString()); // put in a collection
		String c5946 = (String)map5946.get("key5946"); // get it back out
		String d5946 = c5946.substring(0,c5946.length()-1); // extract most of it
		String e5946 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5946.getBytes() ) )); // B64 encode and decode it
		String f5946 = e5946.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5946); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.addBatch( sql );
			int[] counts = statement.executeBatch();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
