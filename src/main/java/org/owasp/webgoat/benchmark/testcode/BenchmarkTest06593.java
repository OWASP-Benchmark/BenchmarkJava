package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06593")
public class BenchmarkTest06593 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a80166 = param; //assign
		StringBuilder b80166 = new StringBuilder(a80166);  // stick in stringbuilder
		b80166.append(" SafeStuff"); // append some safe content
		b80166.replace(b80166.length()-"Chars".length(),b80166.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80166 = new java.util.HashMap<String,Object>();
		map80166.put("key80166", b80166.toString()); // put in a collection
		String c80166 = (String)map80166.get("key80166"); // get it back out
		String d80166 = c80166.substring(0,c80166.length()-1); // extract most of it
		String e80166 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80166.getBytes() ) )); // B64 encode and decode it
		String f80166 = e80166.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g80166 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g80166); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
