package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15286")
public class BenchmarkTest15286 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.addBatch( sql );
			int[] counts = statement.executeBatch();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a96907 = param; //assign
		StringBuilder b96907 = new StringBuilder(a96907);  // stick in stringbuilder
		b96907.append(" SafeStuff"); // append some safe content
		b96907.replace(b96907.length()-"Chars".length(),b96907.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96907 = new java.util.HashMap<String,Object>();
		map96907.put("key96907", b96907.toString()); // put in a collection
		String c96907 = (String)map96907.get("key96907"); // get it back out
		String d96907 = c96907.substring(0,c96907.length()-1); // extract most of it
		String e96907 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96907.getBytes() ) )); // B64 encode and decode it
		String f96907 = e96907.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g96907 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g96907); // reflection
	
		return bar;	
	}
}
