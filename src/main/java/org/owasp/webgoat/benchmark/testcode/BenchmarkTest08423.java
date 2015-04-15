package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08423")
public class BenchmarkTest08423 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9250 = param; //assign
		StringBuilder b9250 = new StringBuilder(a9250);  // stick in stringbuilder
		b9250.append(" SafeStuff"); // append some safe content
		b9250.replace(b9250.length()-"Chars".length(),b9250.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9250 = new java.util.HashMap<String,Object>();
		map9250.put("key9250", b9250.toString()); // put in a collection
		String c9250 = (String)map9250.get("key9250"); // get it back out
		String d9250 = c9250.substring(0,c9250.length()-1); // extract most of it
		String e9250 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9250.getBytes() ) )); // B64 encode and decode it
		String f9250 = e9250.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9250); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
