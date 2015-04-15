package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17215")
public class BenchmarkTest17215 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43448 = param; //assign
		StringBuilder b43448 = new StringBuilder(a43448);  // stick in stringbuilder
		b43448.append(" SafeStuff"); // append some safe content
		b43448.replace(b43448.length()-"Chars".length(),b43448.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43448 = new java.util.HashMap<String,Object>();
		map43448.put("key43448", b43448.toString()); // put in a collection
		String c43448 = (String)map43448.get("key43448"); // get it back out
		String d43448 = c43448.substring(0,c43448.length()-1); // extract most of it
		String e43448 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43448.getBytes() ) )); // B64 encode and decode it
		String f43448 = e43448.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43448 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43448); // reflection
	
		return bar;	
	}
}
