package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20301")
public class BenchmarkTest20301 extends HttpServlet {
	
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
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61426 = param; //assign
		StringBuilder b61426 = new StringBuilder(a61426);  // stick in stringbuilder
		b61426.append(" SafeStuff"); // append some safe content
		b61426.replace(b61426.length()-"Chars".length(),b61426.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61426 = new java.util.HashMap<String,Object>();
		map61426.put("key61426", b61426.toString()); // put in a collection
		String c61426 = (String)map61426.get("key61426"); // get it back out
		String d61426 = c61426.substring(0,c61426.length()-1); // extract most of it
		String e61426 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61426.getBytes() ) )); // B64 encode and decode it
		String f61426 = e61426.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61426 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61426); // reflection
	
		return bar;	
	}
}
