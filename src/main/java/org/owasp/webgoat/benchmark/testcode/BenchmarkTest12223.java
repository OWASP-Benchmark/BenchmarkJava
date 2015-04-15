package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12223")
public class BenchmarkTest12223 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql, new String[] {"user","password"} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26266 = param; //assign
		StringBuilder b26266 = new StringBuilder(a26266);  // stick in stringbuilder
		b26266.append(" SafeStuff"); // append some safe content
		b26266.replace(b26266.length()-"Chars".length(),b26266.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26266 = new java.util.HashMap<String,Object>();
		map26266.put("key26266", b26266.toString()); // put in a collection
		String c26266 = (String)map26266.get("key26266"); // get it back out
		String d26266 = c26266.substring(0,c26266.length()-1); // extract most of it
		String e26266 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26266.getBytes() ) )); // B64 encode and decode it
		String f26266 = e26266.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f26266); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
