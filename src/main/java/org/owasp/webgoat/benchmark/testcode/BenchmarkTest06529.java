package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06529")
public class BenchmarkTest06529 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a54462 = param; //assign
		StringBuilder b54462 = new StringBuilder(a54462);  // stick in stringbuilder
		b54462.append(" SafeStuff"); // append some safe content
		b54462.replace(b54462.length()-"Chars".length(),b54462.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54462 = new java.util.HashMap<String,Object>();
		map54462.put("key54462", b54462.toString()); // put in a collection
		String c54462 = (String)map54462.get("key54462"); // get it back out
		String d54462 = c54462.substring(0,c54462.length()-1); // extract most of it
		String e54462 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54462.getBytes() ) )); // B64 encode and decode it
		String f54462 = e54462.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54462); // reflection
		
		
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
