package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15327")
public class BenchmarkTest15327 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51793 = param; //assign
		StringBuilder b51793 = new StringBuilder(a51793);  // stick in stringbuilder
		b51793.append(" SafeStuff"); // append some safe content
		b51793.replace(b51793.length()-"Chars".length(),b51793.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51793 = new java.util.HashMap<String,Object>();
		map51793.put("key51793", b51793.toString()); // put in a collection
		String c51793 = (String)map51793.get("key51793"); // get it back out
		String d51793 = c51793.substring(0,c51793.length()-1); // extract most of it
		String e51793 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51793.getBytes() ) )); // B64 encode and decode it
		String f51793 = e51793.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51793); // reflection
	
		return bar;	
	}
}
