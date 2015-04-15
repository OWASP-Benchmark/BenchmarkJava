package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06540")
public class BenchmarkTest06540 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a63175 = param; //assign
		StringBuilder b63175 = new StringBuilder(a63175);  // stick in stringbuilder
		b63175.append(" SafeStuff"); // append some safe content
		b63175.replace(b63175.length()-"Chars".length(),b63175.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63175 = new java.util.HashMap<String,Object>();
		map63175.put("key63175", b63175.toString()); // put in a collection
		String c63175 = (String)map63175.get("key63175"); // get it back out
		String d63175 = c63175.substring(0,c63175.length()-1); // extract most of it
		String e63175 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63175.getBytes() ) )); // B64 encode and decode it
		String f63175 = e63175.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63175); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
