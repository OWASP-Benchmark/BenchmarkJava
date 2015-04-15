package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01564")
public class BenchmarkTest01564 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a50052 = param; //assign
		StringBuilder b50052 = new StringBuilder(a50052);  // stick in stringbuilder
		b50052.append(" SafeStuff"); // append some safe content
		b50052.replace(b50052.length()-"Chars".length(),b50052.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50052 = new java.util.HashMap<String,Object>();
		map50052.put("key50052", b50052.toString()); // put in a collection
		String c50052 = (String)map50052.get("key50052"); // get it back out
		String d50052 = c50052.substring(0,c50052.length()-1); // extract most of it
		String e50052 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50052.getBytes() ) )); // B64 encode and decode it
		String f50052 = e50052.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50052); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
