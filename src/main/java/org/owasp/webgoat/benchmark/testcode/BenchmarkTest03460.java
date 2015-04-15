package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03460")
public class BenchmarkTest03460 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a92046 = param; //assign
		StringBuilder b92046 = new StringBuilder(a92046);  // stick in stringbuilder
		b92046.append(" SafeStuff"); // append some safe content
		b92046.replace(b92046.length()-"Chars".length(),b92046.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92046 = new java.util.HashMap<String,Object>();
		map92046.put("key92046", b92046.toString()); // put in a collection
		String c92046 = (String)map92046.get("key92046"); // get it back out
		String d92046 = c92046.substring(0,c92046.length()-1); // extract most of it
		String e92046 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92046.getBytes() ) )); // B64 encode and decode it
		String f92046 = e92046.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92046 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92046); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
