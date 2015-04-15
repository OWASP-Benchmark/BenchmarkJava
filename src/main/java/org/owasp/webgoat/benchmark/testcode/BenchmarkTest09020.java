package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09020")
public class BenchmarkTest09020 extends HttpServlet {
	
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
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51992 = param; //assign
		StringBuilder b51992 = new StringBuilder(a51992);  // stick in stringbuilder
		b51992.append(" SafeStuff"); // append some safe content
		b51992.replace(b51992.length()-"Chars".length(),b51992.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51992 = new java.util.HashMap<String,Object>();
		map51992.put("key51992", b51992.toString()); // put in a collection
		String c51992 = (String)map51992.get("key51992"); // get it back out
		String d51992 = c51992.substring(0,c51992.length()-1); // extract most of it
		String e51992 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51992.getBytes() ) )); // B64 encode and decode it
		String f51992 = e51992.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51992 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51992); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
