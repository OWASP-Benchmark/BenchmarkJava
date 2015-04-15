package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15240")
public class BenchmarkTest15240 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql,
				java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY, 
				java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT );
				statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a12505 = param; //assign
		StringBuilder b12505 = new StringBuilder(a12505);  // stick in stringbuilder
		b12505.append(" SafeStuff"); // append some safe content
		b12505.replace(b12505.length()-"Chars".length(),b12505.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12505 = new java.util.HashMap<String,Object>();
		map12505.put("key12505", b12505.toString()); // put in a collection
		String c12505 = (String)map12505.get("key12505"); // get it back out
		String d12505 = c12505.substring(0,c12505.length()-1); // extract most of it
		String e12505 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12505.getBytes() ) )); // B64 encode and decode it
		String f12505 = e12505.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f12505); // reflection
	
		return bar;	
	}
}
