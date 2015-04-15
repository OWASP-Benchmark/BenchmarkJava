package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18465")
public class BenchmarkTest18465 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94221 = param; //assign
		StringBuilder b94221 = new StringBuilder(a94221);  // stick in stringbuilder
		b94221.append(" SafeStuff"); // append some safe content
		b94221.replace(b94221.length()-"Chars".length(),b94221.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94221 = new java.util.HashMap<String,Object>();
		map94221.put("key94221", b94221.toString()); // put in a collection
		String c94221 = (String)map94221.get("key94221"); // get it back out
		String d94221 = c94221.substring(0,c94221.length()-1); // extract most of it
		String e94221 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94221.getBytes() ) )); // B64 encode and decode it
		String f94221 = e94221.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94221); // reflection
	
		return bar;	
	}
}
