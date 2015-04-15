package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04669")
public class BenchmarkTest04669 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a82940 = param; //assign
		StringBuilder b82940 = new StringBuilder(a82940);  // stick in stringbuilder
		b82940.append(" SafeStuff"); // append some safe content
		b82940.replace(b82940.length()-"Chars".length(),b82940.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82940 = new java.util.HashMap<String,Object>();
		map82940.put("key82940", b82940.toString()); // put in a collection
		String c82940 = (String)map82940.get("key82940"); // get it back out
		String d82940 = c82940.substring(0,c82940.length()-1); // extract most of it
		String e82940 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82940.getBytes() ) )); // B64 encode and decode it
		String f82940 = e82940.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82940); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
