package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01548")
public class BenchmarkTest01548 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a88790 = param; //assign
		StringBuilder b88790 = new StringBuilder(a88790);  // stick in stringbuilder
		b88790.append(" SafeStuff"); // append some safe content
		b88790.replace(b88790.length()-"Chars".length(),b88790.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88790 = new java.util.HashMap<String,Object>();
		map88790.put("key88790", b88790.toString()); // put in a collection
		String c88790 = (String)map88790.get("key88790"); // get it back out
		String d88790 = c88790.substring(0,c88790.length()-1); // extract most of it
		String e88790 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88790.getBytes() ) )); // B64 encode and decode it
		String f88790 = e88790.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88790); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
