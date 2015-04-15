package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10283")
public class BenchmarkTest10283 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55396 = param; //assign
		StringBuilder b55396 = new StringBuilder(a55396);  // stick in stringbuilder
		b55396.append(" SafeStuff"); // append some safe content
		b55396.replace(b55396.length()-"Chars".length(),b55396.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55396 = new java.util.HashMap<String,Object>();
		map55396.put("key55396", b55396.toString()); // put in a collection
		String c55396 = (String)map55396.get("key55396"); // get it back out
		String d55396 = c55396.substring(0,c55396.length()-1); // extract most of it
		String e55396 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55396.getBytes() ) )); // B64 encode and decode it
		String f55396 = e55396.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55396 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55396); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
