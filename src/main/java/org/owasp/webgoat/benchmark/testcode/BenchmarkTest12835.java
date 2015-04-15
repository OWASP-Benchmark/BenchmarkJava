package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12835")
public class BenchmarkTest12835 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

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
		String a56547 = param; //assign
		StringBuilder b56547 = new StringBuilder(a56547);  // stick in stringbuilder
		b56547.append(" SafeStuff"); // append some safe content
		b56547.replace(b56547.length()-"Chars".length(),b56547.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56547 = new java.util.HashMap<String,Object>();
		map56547.put("key56547", b56547.toString()); // put in a collection
		String c56547 = (String)map56547.get("key56547"); // get it back out
		String d56547 = c56547.substring(0,c56547.length()-1); // extract most of it
		String e56547 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56547.getBytes() ) )); // B64 encode and decode it
		String f56547 = e56547.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f56547); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
