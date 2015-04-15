package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20313")
public class BenchmarkTest20313 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1208 = param; //assign
		StringBuilder b1208 = new StringBuilder(a1208);  // stick in stringbuilder
		b1208.append(" SafeStuff"); // append some safe content
		b1208.replace(b1208.length()-"Chars".length(),b1208.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1208 = new java.util.HashMap<String,Object>();
		map1208.put("key1208", b1208.toString()); // put in a collection
		String c1208 = (String)map1208.get("key1208"); // get it back out
		String d1208 = c1208.substring(0,c1208.length()-1); // extract most of it
		String e1208 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1208.getBytes() ) )); // B64 encode and decode it
		String f1208 = e1208.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1208); // reflection
	
		return bar;	
	}
}
