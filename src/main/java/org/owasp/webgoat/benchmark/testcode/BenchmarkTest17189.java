package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17189")
public class BenchmarkTest17189 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a76778 = param; //assign
		StringBuilder b76778 = new StringBuilder(a76778);  // stick in stringbuilder
		b76778.append(" SafeStuff"); // append some safe content
		b76778.replace(b76778.length()-"Chars".length(),b76778.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76778 = new java.util.HashMap<String,Object>();
		map76778.put("key76778", b76778.toString()); // put in a collection
		String c76778 = (String)map76778.get("key76778"); // get it back out
		String d76778 = c76778.substring(0,c76778.length()-1); // extract most of it
		String e76778 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76778.getBytes() ) )); // B64 encode and decode it
		String f76778 = e76778.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76778 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76778); // reflection
	
		return bar;	
	}
}
