package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18457")
public class BenchmarkTest18457 extends HttpServlet {
	
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
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32989 = param; //assign
		StringBuilder b32989 = new StringBuilder(a32989);  // stick in stringbuilder
		b32989.append(" SafeStuff"); // append some safe content
		b32989.replace(b32989.length()-"Chars".length(),b32989.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32989 = new java.util.HashMap<String,Object>();
		map32989.put("key32989", b32989.toString()); // put in a collection
		String c32989 = (String)map32989.get("key32989"); // get it back out
		String d32989 = c32989.substring(0,c32989.length()-1); // extract most of it
		String e32989 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32989.getBytes() ) )); // B64 encode and decode it
		String f32989 = e32989.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32989); // reflection
	
		return bar;	
	}
}
