package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20323")
public class BenchmarkTest20323 extends HttpServlet {
	
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
		String a3296 = param; //assign
		StringBuilder b3296 = new StringBuilder(a3296);  // stick in stringbuilder
		b3296.append(" SafeStuff"); // append some safe content
		b3296.replace(b3296.length()-"Chars".length(),b3296.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3296 = new java.util.HashMap<String,Object>();
		map3296.put("key3296", b3296.toString()); // put in a collection
		String c3296 = (String)map3296.get("key3296"); // get it back out
		String d3296 = c3296.substring(0,c3296.length()-1); // extract most of it
		String e3296 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3296.getBytes() ) )); // B64 encode and decode it
		String f3296 = e3296.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3296); // reflection
	
		return bar;	
	}
}
