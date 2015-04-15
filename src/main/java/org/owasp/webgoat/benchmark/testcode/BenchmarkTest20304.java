package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20304")
public class BenchmarkTest20304 extends HttpServlet {
	
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
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64244 = param; //assign
		StringBuilder b64244 = new StringBuilder(a64244);  // stick in stringbuilder
		b64244.append(" SafeStuff"); // append some safe content
		b64244.replace(b64244.length()-"Chars".length(),b64244.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64244 = new java.util.HashMap<String,Object>();
		map64244.put("key64244", b64244.toString()); // put in a collection
		String c64244 = (String)map64244.get("key64244"); // get it back out
		String d64244 = c64244.substring(0,c64244.length()-1); // extract most of it
		String e64244 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64244.getBytes() ) )); // B64 encode and decode it
		String f64244 = e64244.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64244); // reflection
	
		return bar;	
	}
}
