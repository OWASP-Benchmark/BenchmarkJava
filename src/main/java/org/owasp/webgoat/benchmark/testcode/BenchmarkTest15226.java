package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15226")
public class BenchmarkTest15226 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68114 = param; //assign
		StringBuilder b68114 = new StringBuilder(a68114);  // stick in stringbuilder
		b68114.append(" SafeStuff"); // append some safe content
		b68114.replace(b68114.length()-"Chars".length(),b68114.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68114 = new java.util.HashMap<String,Object>();
		map68114.put("key68114", b68114.toString()); // put in a collection
		String c68114 = (String)map68114.get("key68114"); // get it back out
		String d68114 = c68114.substring(0,c68114.length()-1); // extract most of it
		String e68114 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68114.getBytes() ) )); // B64 encode and decode it
		String f68114 = e68114.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68114); // reflection
	
		return bar;	
	}
}
