package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20279")
public class BenchmarkTest20279 extends HttpServlet {
	
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
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.addBatch( sql );
			int[] counts = statement.executeBatch();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20488 = param; //assign
		StringBuilder b20488 = new StringBuilder(a20488);  // stick in stringbuilder
		b20488.append(" SafeStuff"); // append some safe content
		b20488.replace(b20488.length()-"Chars".length(),b20488.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20488 = new java.util.HashMap<String,Object>();
		map20488.put("key20488", b20488.toString()); // put in a collection
		String c20488 = (String)map20488.get("key20488"); // get it back out
		String d20488 = c20488.substring(0,c20488.length()-1); // extract most of it
		String e20488 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20488.getBytes() ) )); // B64 encode and decode it
		String f20488 = e20488.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g20488 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g20488); // reflection
	
		return bar;	
	}
}
