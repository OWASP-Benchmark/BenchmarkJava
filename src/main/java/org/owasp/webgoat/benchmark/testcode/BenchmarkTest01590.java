package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01590")
public class BenchmarkTest01590 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a27237 = param; //assign
		StringBuilder b27237 = new StringBuilder(a27237);  // stick in stringbuilder
		b27237.append(" SafeStuff"); // append some safe content
		b27237.replace(b27237.length()-"Chars".length(),b27237.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27237 = new java.util.HashMap<String,Object>();
		map27237.put("key27237", b27237.toString()); // put in a collection
		String c27237 = (String)map27237.get("key27237"); // get it back out
		String d27237 = c27237.substring(0,c27237.length()-1); // extract most of it
		String e27237 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27237.getBytes() ) )); // B64 encode and decode it
		String f27237 = e27237.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27237); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
