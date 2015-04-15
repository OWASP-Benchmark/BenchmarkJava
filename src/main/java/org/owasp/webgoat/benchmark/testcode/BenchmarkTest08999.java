package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08999")
public class BenchmarkTest08999 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

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
		String a20911 = param; //assign
		StringBuilder b20911 = new StringBuilder(a20911);  // stick in stringbuilder
		b20911.append(" SafeStuff"); // append some safe content
		b20911.replace(b20911.length()-"Chars".length(),b20911.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20911 = new java.util.HashMap<String,Object>();
		map20911.put("key20911", b20911.toString()); // put in a collection
		String c20911 = (String)map20911.get("key20911"); // get it back out
		String d20911 = c20911.substring(0,c20911.length()-1); // extract most of it
		String e20911 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20911.getBytes() ) )); // B64 encode and decode it
		String f20911 = e20911.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20911); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
