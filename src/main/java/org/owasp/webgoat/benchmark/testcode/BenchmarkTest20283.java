package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20283")
public class BenchmarkTest20283 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47824 = param; //assign
		StringBuilder b47824 = new StringBuilder(a47824);  // stick in stringbuilder
		b47824.append(" SafeStuff"); // append some safe content
		b47824.replace(b47824.length()-"Chars".length(),b47824.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47824 = new java.util.HashMap<String,Object>();
		map47824.put("key47824", b47824.toString()); // put in a collection
		String c47824 = (String)map47824.get("key47824"); // get it back out
		String d47824 = c47824.substring(0,c47824.length()-1); // extract most of it
		String e47824 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47824.getBytes() ) )); // B64 encode and decode it
		String f47824 = e47824.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g47824 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47824); // reflection
	
		return bar;	
	}
}
