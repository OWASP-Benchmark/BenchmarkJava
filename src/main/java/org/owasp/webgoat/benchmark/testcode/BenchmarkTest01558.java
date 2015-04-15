package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01558")
public class BenchmarkTest01558 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a7010 = param; //assign
		StringBuilder b7010 = new StringBuilder(a7010);  // stick in stringbuilder
		b7010.append(" SafeStuff"); // append some safe content
		b7010.replace(b7010.length()-"Chars".length(),b7010.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7010 = new java.util.HashMap<String,Object>();
		map7010.put("key7010", b7010.toString()); // put in a collection
		String c7010 = (String)map7010.get("key7010"); // get it back out
		String d7010 = c7010.substring(0,c7010.length()-1); // extract most of it
		String e7010 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7010.getBytes() ) )); // B64 encode and decode it
		String f7010 = e7010.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g7010 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g7010); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
