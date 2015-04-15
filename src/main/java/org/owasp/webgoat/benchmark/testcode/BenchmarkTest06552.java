package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06552")
public class BenchmarkTest06552 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a82146 = param; //assign
		StringBuilder b82146 = new StringBuilder(a82146);  // stick in stringbuilder
		b82146.append(" SafeStuff"); // append some safe content
		b82146.replace(b82146.length()-"Chars".length(),b82146.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82146 = new java.util.HashMap<String,Object>();
		map82146.put("key82146", b82146.toString()); // put in a collection
		String c82146 = (String)map82146.get("key82146"); // get it back out
		String d82146 = c82146.substring(0,c82146.length()-1); // extract most of it
		String e82146 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82146.getBytes() ) )); // B64 encode and decode it
		String f82146 = e82146.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g82146 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82146); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
