package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14054")
public class BenchmarkTest14054 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36288 = param; //assign
		StringBuilder b36288 = new StringBuilder(a36288);  // stick in stringbuilder
		b36288.append(" SafeStuff"); // append some safe content
		b36288.replace(b36288.length()-"Chars".length(),b36288.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36288 = new java.util.HashMap<String,Object>();
		map36288.put("key36288", b36288.toString()); // put in a collection
		String c36288 = (String)map36288.get("key36288"); // get it back out
		String d36288 = c36288.substring(0,c36288.length()-1); // extract most of it
		String e36288 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36288.getBytes() ) )); // B64 encode and decode it
		String f36288 = e36288.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f36288); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
