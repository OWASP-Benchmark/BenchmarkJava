package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03391")
public class BenchmarkTest03391 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a87063 = param; //assign
		StringBuilder b87063 = new StringBuilder(a87063);  // stick in stringbuilder
		b87063.append(" SafeStuff"); // append some safe content
		b87063.replace(b87063.length()-"Chars".length(),b87063.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87063 = new java.util.HashMap<String,Object>();
		map87063.put("key87063", b87063.toString()); // put in a collection
		String c87063 = (String)map87063.get("key87063"); // get it back out
		String d87063 = c87063.substring(0,c87063.length()-1); // extract most of it
		String e87063 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87063.getBytes() ) )); // B64 encode and decode it
		String f87063 = e87063.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87063 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87063); // reflection
		
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql );
		    statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
