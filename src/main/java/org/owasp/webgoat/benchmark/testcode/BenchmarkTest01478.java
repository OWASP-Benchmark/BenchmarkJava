package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01478")
public class BenchmarkTest01478 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a25996 = param; //assign
		StringBuilder b25996 = new StringBuilder(a25996);  // stick in stringbuilder
		b25996.append(" SafeStuff"); // append some safe content
		b25996.replace(b25996.length()-"Chars".length(),b25996.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25996 = new java.util.HashMap<String,Object>();
		map25996.put("key25996", b25996.toString()); // put in a collection
		String c25996 = (String)map25996.get("key25996"); // get it back out
		String d25996 = c25996.substring(0,c25996.length()-1); // extract most of it
		String e25996 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25996.getBytes() ) )); // B64 encode and decode it
		String f25996 = e25996.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25996); // reflection
		
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql );
		    statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
