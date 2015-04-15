package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08426")
public class BenchmarkTest08426 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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
		String a89617 = param; //assign
		StringBuilder b89617 = new StringBuilder(a89617);  // stick in stringbuilder
		b89617.append(" SafeStuff"); // append some safe content
		b89617.replace(b89617.length()-"Chars".length(),b89617.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89617 = new java.util.HashMap<String,Object>();
		map89617.put("key89617", b89617.toString()); // put in a collection
		String c89617 = (String)map89617.get("key89617"); // get it back out
		String d89617 = c89617.substring(0,c89617.length()-1); // extract most of it
		String e89617 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89617.getBytes() ) )); // B64 encode and decode it
		String f89617 = e89617.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89617); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
