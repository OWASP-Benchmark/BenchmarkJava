package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13986")
public class BenchmarkTest13986 extends HttpServlet {
	
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
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new int[] { 1, 2 } );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91642 = param; //assign
		StringBuilder b91642 = new StringBuilder(a91642);  // stick in stringbuilder
		b91642.append(" SafeStuff"); // append some safe content
		b91642.replace(b91642.length()-"Chars".length(),b91642.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91642 = new java.util.HashMap<String,Object>();
		map91642.put("key91642", b91642.toString()); // put in a collection
		String c91642 = (String)map91642.get("key91642"); // get it back out
		String d91642 = c91642.substring(0,c91642.length()-1); // extract most of it
		String e91642 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91642.getBytes() ) )); // B64 encode and decode it
		String f91642 = e91642.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91642); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
