package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10262")
public class BenchmarkTest10262 extends HttpServlet {
	
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
		String a57858 = param; //assign
		StringBuilder b57858 = new StringBuilder(a57858);  // stick in stringbuilder
		b57858.append(" SafeStuff"); // append some safe content
		b57858.replace(b57858.length()-"Chars".length(),b57858.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57858 = new java.util.HashMap<String,Object>();
		map57858.put("key57858", b57858.toString()); // put in a collection
		String c57858 = (String)map57858.get("key57858"); // get it back out
		String d57858 = c57858.substring(0,c57858.length()-1); // extract most of it
		String e57858 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57858.getBytes() ) )); // B64 encode and decode it
		String f57858 = e57858.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g57858 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g57858); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
