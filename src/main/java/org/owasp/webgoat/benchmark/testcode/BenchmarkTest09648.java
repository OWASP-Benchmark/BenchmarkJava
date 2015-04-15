package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09648")
public class BenchmarkTest09648 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23499 = param; //assign
		StringBuilder b23499 = new StringBuilder(a23499);  // stick in stringbuilder
		b23499.append(" SafeStuff"); // append some safe content
		b23499.replace(b23499.length()-"Chars".length(),b23499.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23499 = new java.util.HashMap<String,Object>();
		map23499.put("key23499", b23499.toString()); // put in a collection
		String c23499 = (String)map23499.get("key23499"); // get it back out
		String d23499 = c23499.substring(0,c23499.length()-1); // extract most of it
		String e23499 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23499.getBytes() ) )); // B64 encode and decode it
		String f23499 = e23499.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23499); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
