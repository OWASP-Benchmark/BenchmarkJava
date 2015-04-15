package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15965")
public class BenchmarkTest15965 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

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
		String a6179 = param; //assign
		StringBuilder b6179 = new StringBuilder(a6179);  // stick in stringbuilder
		b6179.append(" SafeStuff"); // append some safe content
		b6179.replace(b6179.length()-"Chars".length(),b6179.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6179 = new java.util.HashMap<String,Object>();
		map6179.put("key6179", b6179.toString()); // put in a collection
		String c6179 = (String)map6179.get("key6179"); // get it back out
		String d6179 = c6179.substring(0,c6179.length()-1); // extract most of it
		String e6179 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6179.getBytes() ) )); // B64 encode and decode it
		String f6179 = e6179.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6179); // reflection
	
		return bar;	
	}
}
