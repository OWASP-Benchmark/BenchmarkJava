package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08376")
public class BenchmarkTest08376 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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
		String a61433 = param; //assign
		StringBuilder b61433 = new StringBuilder(a61433);  // stick in stringbuilder
		b61433.append(" SafeStuff"); // append some safe content
		b61433.replace(b61433.length()-"Chars".length(),b61433.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61433 = new java.util.HashMap<String,Object>();
		map61433.put("key61433", b61433.toString()); // put in a collection
		String c61433 = (String)map61433.get("key61433"); // get it back out
		String d61433 = c61433.substring(0,c61433.length()-1); // extract most of it
		String e61433 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61433.getBytes() ) )); // B64 encode and decode it
		String f61433 = e61433.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61433 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61433); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
