package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06576")
public class BenchmarkTest06576 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a84473 = param; //assign
		StringBuilder b84473 = new StringBuilder(a84473);  // stick in stringbuilder
		b84473.append(" SafeStuff"); // append some safe content
		b84473.replace(b84473.length()-"Chars".length(),b84473.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84473 = new java.util.HashMap<String,Object>();
		map84473.put("key84473", b84473.toString()); // put in a collection
		String c84473 = (String)map84473.get("key84473"); // get it back out
		String d84473 = c84473.substring(0,c84473.length()-1); // extract most of it
		String e84473 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84473.getBytes() ) )); // B64 encode and decode it
		String f84473 = e84473.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f84473); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
