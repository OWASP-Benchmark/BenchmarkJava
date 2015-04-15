package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03489")
public class BenchmarkTest03489 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a39895 = param; //assign
		StringBuilder b39895 = new StringBuilder(a39895);  // stick in stringbuilder
		b39895.append(" SafeStuff"); // append some safe content
		b39895.replace(b39895.length()-"Chars".length(),b39895.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39895 = new java.util.HashMap<String,Object>();
		map39895.put("key39895", b39895.toString()); // put in a collection
		String c39895 = (String)map39895.get("key39895"); // get it back out
		String d39895 = c39895.substring(0,c39895.length()-1); // extract most of it
		String e39895 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39895.getBytes() ) )); // B64 encode and decode it
		String f39895 = e39895.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f39895); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
