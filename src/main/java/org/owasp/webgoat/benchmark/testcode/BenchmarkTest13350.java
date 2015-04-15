package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13350")
public class BenchmarkTest13350 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a40376 = param; //assign
		StringBuilder b40376 = new StringBuilder(a40376);  // stick in stringbuilder
		b40376.append(" SafeStuff"); // append some safe content
		b40376.replace(b40376.length()-"Chars".length(),b40376.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40376 = new java.util.HashMap<String,Object>();
		map40376.put("key40376", b40376.toString()); // put in a collection
		String c40376 = (String)map40376.get("key40376"); // get it back out
		String d40376 = c40376.substring(0,c40376.length()-1); // extract most of it
		String e40376 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40376.getBytes() ) )); // B64 encode and decode it
		String f40376 = e40376.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40376); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
