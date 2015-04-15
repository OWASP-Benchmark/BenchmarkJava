package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17196")
public class BenchmarkTest17196 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88256 = param; //assign
		StringBuilder b88256 = new StringBuilder(a88256);  // stick in stringbuilder
		b88256.append(" SafeStuff"); // append some safe content
		b88256.replace(b88256.length()-"Chars".length(),b88256.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88256 = new java.util.HashMap<String,Object>();
		map88256.put("key88256", b88256.toString()); // put in a collection
		String c88256 = (String)map88256.get("key88256"); // get it back out
		String d88256 = c88256.substring(0,c88256.length()-1); // extract most of it
		String e88256 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88256.getBytes() ) )); // B64 encode and decode it
		String f88256 = e88256.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88256 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88256); // reflection
	
		return bar;	
	}
}
