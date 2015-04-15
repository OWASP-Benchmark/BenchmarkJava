package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12803")
public class BenchmarkTest12803 extends HttpServlet {
	
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
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8173 = param; //assign
		StringBuilder b8173 = new StringBuilder(a8173);  // stick in stringbuilder
		b8173.append(" SafeStuff"); // append some safe content
		b8173.replace(b8173.length()-"Chars".length(),b8173.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8173 = new java.util.HashMap<String,Object>();
		map8173.put("key8173", b8173.toString()); // put in a collection
		String c8173 = (String)map8173.get("key8173"); // get it back out
		String d8173 = c8173.substring(0,c8173.length()-1); // extract most of it
		String e8173 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8173.getBytes() ) )); // B64 encode and decode it
		String f8173 = e8173.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f8173); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
