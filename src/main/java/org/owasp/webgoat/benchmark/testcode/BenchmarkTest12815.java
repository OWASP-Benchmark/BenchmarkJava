package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12815")
public class BenchmarkTest12815 extends HttpServlet {
	
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
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53230 = param; //assign
		StringBuilder b53230 = new StringBuilder(a53230);  // stick in stringbuilder
		b53230.append(" SafeStuff"); // append some safe content
		b53230.replace(b53230.length()-"Chars".length(),b53230.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53230 = new java.util.HashMap<String,Object>();
		map53230.put("key53230", b53230.toString()); // put in a collection
		String c53230 = (String)map53230.get("key53230"); // get it back out
		String d53230 = c53230.substring(0,c53230.length()-1); // extract most of it
		String e53230 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53230.getBytes() ) )); // B64 encode and decode it
		String f53230 = e53230.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g53230 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53230); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
