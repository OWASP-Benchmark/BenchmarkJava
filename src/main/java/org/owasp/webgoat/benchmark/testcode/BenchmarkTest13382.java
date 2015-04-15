package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13382")
public class BenchmarkTest13382 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a19316 = param; //assign
		StringBuilder b19316 = new StringBuilder(a19316);  // stick in stringbuilder
		b19316.append(" SafeStuff"); // append some safe content
		b19316.replace(b19316.length()-"Chars".length(),b19316.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19316 = new java.util.HashMap<String,Object>();
		map19316.put("key19316", b19316.toString()); // put in a collection
		String c19316 = (String)map19316.get("key19316"); // get it back out
		String d19316 = c19316.substring(0,c19316.length()-1); // extract most of it
		String e19316 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19316.getBytes() ) )); // B64 encode and decode it
		String f19316 = e19316.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19316 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19316); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
