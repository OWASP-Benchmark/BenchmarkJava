package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20331")
public class BenchmarkTest20331 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44401 = param; //assign
		StringBuilder b44401 = new StringBuilder(a44401);  // stick in stringbuilder
		b44401.append(" SafeStuff"); // append some safe content
		b44401.replace(b44401.length()-"Chars".length(),b44401.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44401 = new java.util.HashMap<String,Object>();
		map44401.put("key44401", b44401.toString()); // put in a collection
		String c44401 = (String)map44401.get("key44401"); // get it back out
		String d44401 = c44401.substring(0,c44401.length()-1); // extract most of it
		String e44401 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44401.getBytes() ) )); // B64 encode and decode it
		String f44401 = e44401.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44401); // reflection
	
		return bar;	
	}
}
