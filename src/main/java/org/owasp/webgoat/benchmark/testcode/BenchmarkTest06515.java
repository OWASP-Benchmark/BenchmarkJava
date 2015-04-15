package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06515")
public class BenchmarkTest06515 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a18585 = param; //assign
		StringBuilder b18585 = new StringBuilder(a18585);  // stick in stringbuilder
		b18585.append(" SafeStuff"); // append some safe content
		b18585.replace(b18585.length()-"Chars".length(),b18585.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18585 = new java.util.HashMap<String,Object>();
		map18585.put("key18585", b18585.toString()); // put in a collection
		String c18585 = (String)map18585.get("key18585"); // get it back out
		String d18585 = c18585.substring(0,c18585.length()-1); // extract most of it
		String e18585 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18585.getBytes() ) )); // B64 encode and decode it
		String f18585 = e18585.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f18585); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new String[] {"Column1","Column2"} );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
