package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17848")
public class BenchmarkTest17848 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

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
		String a48139 = param; //assign
		StringBuilder b48139 = new StringBuilder(a48139);  // stick in stringbuilder
		b48139.append(" SafeStuff"); // append some safe content
		b48139.replace(b48139.length()-"Chars".length(),b48139.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48139 = new java.util.HashMap<String,Object>();
		map48139.put("key48139", b48139.toString()); // put in a collection
		String c48139 = (String)map48139.get("key48139"); // get it back out
		String d48139 = c48139.substring(0,c48139.length()-1); // extract most of it
		String e48139 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48139.getBytes() ) )); // B64 encode and decode it
		String f48139 = e48139.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48139); // reflection
	
		return bar;	
	}
}
