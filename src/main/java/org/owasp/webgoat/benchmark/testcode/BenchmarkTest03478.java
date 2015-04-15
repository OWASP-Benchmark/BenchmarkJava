package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03478")
public class BenchmarkTest03478 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a31232 = param; //assign
		StringBuilder b31232 = new StringBuilder(a31232);  // stick in stringbuilder
		b31232.append(" SafeStuff"); // append some safe content
		b31232.replace(b31232.length()-"Chars".length(),b31232.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31232 = new java.util.HashMap<String,Object>();
		map31232.put("key31232", b31232.toString()); // put in a collection
		String c31232 = (String)map31232.get("key31232"); // get it back out
		String d31232 = c31232.substring(0,c31232.length()-1); // extract most of it
		String e31232 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31232.getBytes() ) )); // B64 encode and decode it
		String f31232 = e31232.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31232); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
