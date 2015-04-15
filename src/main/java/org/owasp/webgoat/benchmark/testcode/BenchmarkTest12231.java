package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12231")
public class BenchmarkTest12231 extends HttpServlet {
	
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
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20293 = param; //assign
		StringBuilder b20293 = new StringBuilder(a20293);  // stick in stringbuilder
		b20293.append(" SafeStuff"); // append some safe content
		b20293.replace(b20293.length()-"Chars".length(),b20293.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20293 = new java.util.HashMap<String,Object>();
		map20293.put("key20293", b20293.toString()); // put in a collection
		String c20293 = (String)map20293.get("key20293"); // get it back out
		String d20293 = c20293.substring(0,c20293.length()-1); // extract most of it
		String e20293 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20293.getBytes() ) )); // B64 encode and decode it
		String f20293 = e20293.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20293); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
