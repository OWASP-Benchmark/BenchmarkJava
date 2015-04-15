package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17157")
public class BenchmarkTest17157 extends HttpServlet {
	
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
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new String[] {"Column1","Column2"} );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a54615 = param; //assign
		StringBuilder b54615 = new StringBuilder(a54615);  // stick in stringbuilder
		b54615.append(" SafeStuff"); // append some safe content
		b54615.replace(b54615.length()-"Chars".length(),b54615.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54615 = new java.util.HashMap<String,Object>();
		map54615.put("key54615", b54615.toString()); // put in a collection
		String c54615 = (String)map54615.get("key54615"); // get it back out
		String d54615 = c54615.substring(0,c54615.length()-1); // extract most of it
		String e54615 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54615.getBytes() ) )); // B64 encode and decode it
		String f54615 = e54615.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54615); // reflection
	
		return bar;	
	}
}
