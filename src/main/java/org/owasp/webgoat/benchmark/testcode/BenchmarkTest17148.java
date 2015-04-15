package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17148")
public class BenchmarkTest17148 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new int[] { 1, 2 } );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75394 = param; //assign
		StringBuilder b75394 = new StringBuilder(a75394);  // stick in stringbuilder
		b75394.append(" SafeStuff"); // append some safe content
		b75394.replace(b75394.length()-"Chars".length(),b75394.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75394 = new java.util.HashMap<String,Object>();
		map75394.put("key75394", b75394.toString()); // put in a collection
		String c75394 = (String)map75394.get("key75394"); // get it back out
		String d75394 = c75394.substring(0,c75394.length()-1); // extract most of it
		String e75394 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75394.getBytes() ) )); // B64 encode and decode it
		String f75394 = e75394.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f75394); // reflection
	
		return bar;	
	}
}
