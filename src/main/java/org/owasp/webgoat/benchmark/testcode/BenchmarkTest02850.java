package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02850")
public class BenchmarkTest02850 extends HttpServlet {
	
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
		String a48247 = param; //assign
		StringBuilder b48247 = new StringBuilder(a48247);  // stick in stringbuilder
		b48247.append(" SafeStuff"); // append some safe content
		b48247.replace(b48247.length()-"Chars".length(),b48247.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48247 = new java.util.HashMap<String,Object>();
		map48247.put("key48247", b48247.toString()); // put in a collection
		String c48247 = (String)map48247.get("key48247"); // get it back out
		String d48247 = c48247.substring(0,c48247.length()-1); // extract most of it
		String e48247 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48247.getBytes() ) )); // B64 encode and decode it
		String f48247 = e48247.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48247); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
