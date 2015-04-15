package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06560")
public class BenchmarkTest06560 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a82402 = param; //assign
		StringBuilder b82402 = new StringBuilder(a82402);  // stick in stringbuilder
		b82402.append(" SafeStuff"); // append some safe content
		b82402.replace(b82402.length()-"Chars".length(),b82402.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82402 = new java.util.HashMap<String,Object>();
		map82402.put("key82402", b82402.toString()); // put in a collection
		String c82402 = (String)map82402.get("key82402"); // get it back out
		String d82402 = c82402.substring(0,c82402.length()-1); // extract most of it
		String e82402 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82402.getBytes() ) )); // B64 encode and decode it
		String f82402 = e82402.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g82402 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82402); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
