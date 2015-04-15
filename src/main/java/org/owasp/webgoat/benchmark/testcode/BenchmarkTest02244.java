package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02244")
public class BenchmarkTest02244 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a76563 = param; //assign
		StringBuilder b76563 = new StringBuilder(a76563);  // stick in stringbuilder
		b76563.append(" SafeStuff"); // append some safe content
		b76563.replace(b76563.length()-"Chars".length(),b76563.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76563 = new java.util.HashMap<String,Object>();
		map76563.put("key76563", b76563.toString()); // put in a collection
		String c76563 = (String)map76563.get("key76563"); // get it back out
		String d76563 = c76563.substring(0,c76563.length()-1); // extract most of it
		String e76563 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76563.getBytes() ) )); // B64 encode and decode it
		String f76563 = e76563.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76563); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new String[] {"user","password"} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
