package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09052")
public class BenchmarkTest09052 extends HttpServlet {
	
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
		String a60062 = param; //assign
		StringBuilder b60062 = new StringBuilder(a60062);  // stick in stringbuilder
		b60062.append(" SafeStuff"); // append some safe content
		b60062.replace(b60062.length()-"Chars".length(),b60062.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60062 = new java.util.HashMap<String,Object>();
		map60062.put("key60062", b60062.toString()); // put in a collection
		String c60062 = (String)map60062.get("key60062"); // get it back out
		String d60062 = c60062.substring(0,c60062.length()-1); // extract most of it
		String e60062 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60062.getBytes() ) )); // B64 encode and decode it
		String f60062 = e60062.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g60062 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g60062); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
