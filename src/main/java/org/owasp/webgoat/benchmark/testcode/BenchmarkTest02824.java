package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02824")
public class BenchmarkTest02824 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a50906 = param; //assign
		StringBuilder b50906 = new StringBuilder(a50906);  // stick in stringbuilder
		b50906.append(" SafeStuff"); // append some safe content
		b50906.replace(b50906.length()-"Chars".length(),b50906.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50906 = new java.util.HashMap<String,Object>();
		map50906.put("key50906", b50906.toString()); // put in a collection
		String c50906 = (String)map50906.get("key50906"); // get it back out
		String d50906 = c50906.substring(0,c50906.length()-1); // extract most of it
		String e50906 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50906.getBytes() ) )); // B64 encode and decode it
		String f50906 = e50906.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50906); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
