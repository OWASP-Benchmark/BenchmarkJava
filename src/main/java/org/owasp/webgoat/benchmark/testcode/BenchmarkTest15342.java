package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15342")
public class BenchmarkTest15342 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27725 = param; //assign
		StringBuilder b27725 = new StringBuilder(a27725);  // stick in stringbuilder
		b27725.append(" SafeStuff"); // append some safe content
		b27725.replace(b27725.length()-"Chars".length(),b27725.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27725 = new java.util.HashMap<String,Object>();
		map27725.put("key27725", b27725.toString()); // put in a collection
		String c27725 = (String)map27725.get("key27725"); // get it back out
		String d27725 = c27725.substring(0,c27725.length()-1); // extract most of it
		String e27725 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27725.getBytes() ) )); // B64 encode and decode it
		String f27725 = e27725.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g27725 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g27725); // reflection
	
		return bar;	
	}
}
