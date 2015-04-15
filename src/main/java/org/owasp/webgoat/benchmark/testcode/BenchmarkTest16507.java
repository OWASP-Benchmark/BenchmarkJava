package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16507")
public class BenchmarkTest16507 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

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
		String a3536 = param; //assign
		StringBuilder b3536 = new StringBuilder(a3536);  // stick in stringbuilder
		b3536.append(" SafeStuff"); // append some safe content
		b3536.replace(b3536.length()-"Chars".length(),b3536.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3536 = new java.util.HashMap<String,Object>();
		map3536.put("key3536", b3536.toString()); // put in a collection
		String c3536 = (String)map3536.get("key3536"); // get it back out
		String d3536 = c3536.substring(0,c3536.length()-1); // extract most of it
		String e3536 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3536.getBytes() ) )); // B64 encode and decode it
		String f3536 = e3536.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3536); // reflection
	
		return bar;	
	}
}
