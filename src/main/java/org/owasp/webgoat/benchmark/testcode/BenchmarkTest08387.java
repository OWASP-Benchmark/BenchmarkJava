package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08387")
public class BenchmarkTest08387 extends HttpServlet {
	
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
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a12857 = param; //assign
		StringBuilder b12857 = new StringBuilder(a12857);  // stick in stringbuilder
		b12857.append(" SafeStuff"); // append some safe content
		b12857.replace(b12857.length()-"Chars".length(),b12857.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12857 = new java.util.HashMap<String,Object>();
		map12857.put("key12857", b12857.toString()); // put in a collection
		String c12857 = (String)map12857.get("key12857"); // get it back out
		String d12857 = c12857.substring(0,c12857.length()-1); // extract most of it
		String e12857 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12857.getBytes() ) )); // B64 encode and decode it
		String f12857 = e12857.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g12857 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g12857); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
