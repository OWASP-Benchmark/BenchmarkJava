package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05925")
public class BenchmarkTest05925 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a95690 = param; //assign
		StringBuilder b95690 = new StringBuilder(a95690);  // stick in stringbuilder
		b95690.append(" SafeStuff"); // append some safe content
		b95690.replace(b95690.length()-"Chars".length(),b95690.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95690 = new java.util.HashMap<String,Object>();
		map95690.put("key95690", b95690.toString()); // put in a collection
		String c95690 = (String)map95690.get("key95690"); // get it back out
		String d95690 = c95690.substring(0,c95690.length()-1); // extract most of it
		String e95690 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95690.getBytes() ) )); // B64 encode and decode it
		String f95690 = e95690.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95690); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
