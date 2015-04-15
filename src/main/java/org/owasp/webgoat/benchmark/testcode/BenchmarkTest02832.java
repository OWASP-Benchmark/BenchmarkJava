package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02832")
public class BenchmarkTest02832 extends HttpServlet {
	
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
		String a63993 = param; //assign
		StringBuilder b63993 = new StringBuilder(a63993);  // stick in stringbuilder
		b63993.append(" SafeStuff"); // append some safe content
		b63993.replace(b63993.length()-"Chars".length(),b63993.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63993 = new java.util.HashMap<String,Object>();
		map63993.put("key63993", b63993.toString()); // put in a collection
		String c63993 = (String)map63993.get("key63993"); // get it back out
		String d63993 = c63993.substring(0,c63993.length()-1); // extract most of it
		String e63993 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63993.getBytes() ) )); // B64 encode and decode it
		String f63993 = e63993.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63993); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
