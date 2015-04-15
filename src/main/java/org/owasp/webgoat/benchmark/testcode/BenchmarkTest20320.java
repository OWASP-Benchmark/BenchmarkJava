package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20320")
public class BenchmarkTest20320 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a28472 = param; //assign
		StringBuilder b28472 = new StringBuilder(a28472);  // stick in stringbuilder
		b28472.append(" SafeStuff"); // append some safe content
		b28472.replace(b28472.length()-"Chars".length(),b28472.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28472 = new java.util.HashMap<String,Object>();
		map28472.put("key28472", b28472.toString()); // put in a collection
		String c28472 = (String)map28472.get("key28472"); // get it back out
		String d28472 = c28472.substring(0,c28472.length()-1); // extract most of it
		String e28472 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28472.getBytes() ) )); // B64 encode and decode it
		String f28472 = e28472.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g28472 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28472); // reflection
	
		return bar;	
	}
}
