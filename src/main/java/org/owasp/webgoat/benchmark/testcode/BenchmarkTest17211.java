package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17211")
public class BenchmarkTest17211 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a35778 = param; //assign
		StringBuilder b35778 = new StringBuilder(a35778);  // stick in stringbuilder
		b35778.append(" SafeStuff"); // append some safe content
		b35778.replace(b35778.length()-"Chars".length(),b35778.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35778 = new java.util.HashMap<String,Object>();
		map35778.put("key35778", b35778.toString()); // put in a collection
		String c35778 = (String)map35778.get("key35778"); // get it back out
		String d35778 = c35778.substring(0,c35778.length()-1); // extract most of it
		String e35778 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35778.getBytes() ) )); // B64 encode and decode it
		String f35778 = e35778.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35778); // reflection
	
		return bar;	
	}
}
