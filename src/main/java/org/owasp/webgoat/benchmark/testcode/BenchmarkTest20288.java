package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20288")
public class BenchmarkTest20288 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87533 = param; //assign
		StringBuilder b87533 = new StringBuilder(a87533);  // stick in stringbuilder
		b87533.append(" SafeStuff"); // append some safe content
		b87533.replace(b87533.length()-"Chars".length(),b87533.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87533 = new java.util.HashMap<String,Object>();
		map87533.put("key87533", b87533.toString()); // put in a collection
		String c87533 = (String)map87533.get("key87533"); // get it back out
		String d87533 = c87533.substring(0,c87533.length()-1); // extract most of it
		String e87533 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87533.getBytes() ) )); // B64 encode and decode it
		String f87533 = e87533.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87533 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87533); // reflection
	
		return bar;	
	}
}
