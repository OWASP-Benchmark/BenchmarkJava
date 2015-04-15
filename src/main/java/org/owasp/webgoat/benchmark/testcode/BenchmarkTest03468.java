package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03468")
public class BenchmarkTest03468 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a84584 = param; //assign
		StringBuilder b84584 = new StringBuilder(a84584);  // stick in stringbuilder
		b84584.append(" SafeStuff"); // append some safe content
		b84584.replace(b84584.length()-"Chars".length(),b84584.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84584 = new java.util.HashMap<String,Object>();
		map84584.put("key84584", b84584.toString()); // put in a collection
		String c84584 = (String)map84584.get("key84584"); // get it back out
		String d84584 = c84584.substring(0,c84584.length()-1); // extract most of it
		String e84584 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84584.getBytes() ) )); // B64 encode and decode it
		String f84584 = e84584.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84584 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84584); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
