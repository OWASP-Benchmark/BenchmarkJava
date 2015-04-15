package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10272")
public class BenchmarkTest10272 extends HttpServlet {
	
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
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47524 = param; //assign
		StringBuilder b47524 = new StringBuilder(a47524);  // stick in stringbuilder
		b47524.append(" SafeStuff"); // append some safe content
		b47524.replace(b47524.length()-"Chars".length(),b47524.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47524 = new java.util.HashMap<String,Object>();
		map47524.put("key47524", b47524.toString()); // put in a collection
		String c47524 = (String)map47524.get("key47524"); // get it back out
		String d47524 = c47524.substring(0,c47524.length()-1); // extract most of it
		String e47524 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47524.getBytes() ) )); // B64 encode and decode it
		String f47524 = e47524.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47524); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
