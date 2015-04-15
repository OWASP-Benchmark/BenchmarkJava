package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19628")
public class BenchmarkTest19628 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql );
		    statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32219 = param; //assign
		StringBuilder b32219 = new StringBuilder(a32219);  // stick in stringbuilder
		b32219.append(" SafeStuff"); // append some safe content
		b32219.replace(b32219.length()-"Chars".length(),b32219.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32219 = new java.util.HashMap<String,Object>();
		map32219.put("key32219", b32219.toString()); // put in a collection
		String c32219 = (String)map32219.get("key32219"); // get it back out
		String d32219 = c32219.substring(0,c32219.length()-1); // extract most of it
		String e32219 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32219.getBytes() ) )); // B64 encode and decode it
		String f32219 = e32219.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32219); // reflection
	
		return bar;	
	}
}
