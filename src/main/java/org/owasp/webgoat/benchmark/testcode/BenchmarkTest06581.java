package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06581")
public class BenchmarkTest06581 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a86735 = param; //assign
		StringBuilder b86735 = new StringBuilder(a86735);  // stick in stringbuilder
		b86735.append(" SafeStuff"); // append some safe content
		b86735.replace(b86735.length()-"Chars".length(),b86735.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86735 = new java.util.HashMap<String,Object>();
		map86735.put("key86735", b86735.toString()); // put in a collection
		String c86735 = (String)map86735.get("key86735"); // get it back out
		String d86735 = c86735.substring(0,c86735.length()-1); // extract most of it
		String e86735 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86735.getBytes() ) )); // B64 encode and decode it
		String f86735 = e86735.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86735); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
