package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08990")
public class BenchmarkTest08990 extends HttpServlet {
	
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
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66109 = param; //assign
		StringBuilder b66109 = new StringBuilder(a66109);  // stick in stringbuilder
		b66109.append(" SafeStuff"); // append some safe content
		b66109.replace(b66109.length()-"Chars".length(),b66109.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66109 = new java.util.HashMap<String,Object>();
		map66109.put("key66109", b66109.toString()); // put in a collection
		String c66109 = (String)map66109.get("key66109"); // get it back out
		String d66109 = c66109.substring(0,c66109.length()-1); // extract most of it
		String e66109 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66109.getBytes() ) )); // B64 encode and decode it
		String f66109 = e66109.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f66109); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
