package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12166")
public class BenchmarkTest12166 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.addBatch( sql );
			int[] counts = statement.executeBatch();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3553 = param; //assign
		StringBuilder b3553 = new StringBuilder(a3553);  // stick in stringbuilder
		b3553.append(" SafeStuff"); // append some safe content
		b3553.replace(b3553.length()-"Chars".length(),b3553.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3553 = new java.util.HashMap<String,Object>();
		map3553.put("key3553", b3553.toString()); // put in a collection
		String c3553 = (String)map3553.get("key3553"); // get it back out
		String d3553 = c3553.substring(0,c3553.length()-1); // extract most of it
		String e3553 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3553.getBytes() ) )); // B64 encode and decode it
		String f3553 = e3553.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3553); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
