package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09022")
public class BenchmarkTest09022 extends HttpServlet {
	
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
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55179 = param; //assign
		StringBuilder b55179 = new StringBuilder(a55179);  // stick in stringbuilder
		b55179.append(" SafeStuff"); // append some safe content
		b55179.replace(b55179.length()-"Chars".length(),b55179.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55179 = new java.util.HashMap<String,Object>();
		map55179.put("key55179", b55179.toString()); // put in a collection
		String c55179 = (String)map55179.get("key55179"); // get it back out
		String d55179 = c55179.substring(0,c55179.length()-1); // extract most of it
		String e55179 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55179.getBytes() ) )); // B64 encode and decode it
		String f55179 = e55179.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f55179); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
