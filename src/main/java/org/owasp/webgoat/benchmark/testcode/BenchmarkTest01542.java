package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01542")
public class BenchmarkTest01542 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a64044 = param; //assign
		StringBuilder b64044 = new StringBuilder(a64044);  // stick in stringbuilder
		b64044.append(" SafeStuff"); // append some safe content
		b64044.replace(b64044.length()-"Chars".length(),b64044.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64044 = new java.util.HashMap<String,Object>();
		map64044.put("key64044", b64044.toString()); // put in a collection
		String c64044 = (String)map64044.get("key64044"); // get it back out
		String d64044 = c64044.substring(0,c64044.length()-1); // extract most of it
		String e64044 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64044.getBytes() ) )); // B64 encode and decode it
		String f64044 = e64044.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64044 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64044); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
