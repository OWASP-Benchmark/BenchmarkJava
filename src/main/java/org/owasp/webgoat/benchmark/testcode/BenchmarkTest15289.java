package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15289")
public class BenchmarkTest15289 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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
		String a93035 = param; //assign
		StringBuilder b93035 = new StringBuilder(a93035);  // stick in stringbuilder
		b93035.append(" SafeStuff"); // append some safe content
		b93035.replace(b93035.length()-"Chars".length(),b93035.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93035 = new java.util.HashMap<String,Object>();
		map93035.put("key93035", b93035.toString()); // put in a collection
		String c93035 = (String)map93035.get("key93035"); // get it back out
		String d93035 = c93035.substring(0,c93035.length()-1); // extract most of it
		String e93035 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93035.getBytes() ) )); // B64 encode and decode it
		String f93035 = e93035.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93035); // reflection
	
		return bar;	
	}
}
