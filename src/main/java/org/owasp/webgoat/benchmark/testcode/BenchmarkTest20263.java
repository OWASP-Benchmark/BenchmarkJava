package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20263")
public class BenchmarkTest20263 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new String[] {"Column1","Column2"} );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20903 = param; //assign
		StringBuilder b20903 = new StringBuilder(a20903);  // stick in stringbuilder
		b20903.append(" SafeStuff"); // append some safe content
		b20903.replace(b20903.length()-"Chars".length(),b20903.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20903 = new java.util.HashMap<String,Object>();
		map20903.put("key20903", b20903.toString()); // put in a collection
		String c20903 = (String)map20903.get("key20903"); // get it back out
		String d20903 = c20903.substring(0,c20903.length()-1); // extract most of it
		String e20903 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20903.getBytes() ) )); // B64 encode and decode it
		String f20903 = e20903.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20903); // reflection
	
		return bar;	
	}
}
