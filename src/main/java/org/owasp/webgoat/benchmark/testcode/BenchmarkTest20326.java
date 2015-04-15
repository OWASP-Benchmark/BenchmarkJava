package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20326")
public class BenchmarkTest20326 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql, new String[] {"user","password"} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71892 = param; //assign
		StringBuilder b71892 = new StringBuilder(a71892);  // stick in stringbuilder
		b71892.append(" SafeStuff"); // append some safe content
		b71892.replace(b71892.length()-"Chars".length(),b71892.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71892 = new java.util.HashMap<String,Object>();
		map71892.put("key71892", b71892.toString()); // put in a collection
		String c71892 = (String)map71892.get("key71892"); // get it back out
		String d71892 = c71892.substring(0,c71892.length()-1); // extract most of it
		String e71892 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71892.getBytes() ) )); // B64 encode and decode it
		String f71892 = e71892.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71892 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71892); // reflection
	
		return bar;	
	}
}
