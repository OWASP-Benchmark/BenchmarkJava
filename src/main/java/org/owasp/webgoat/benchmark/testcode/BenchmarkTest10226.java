package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10226")
public class BenchmarkTest10226 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql,
				java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY );
				statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a81793 = param; //assign
		StringBuilder b81793 = new StringBuilder(a81793);  // stick in stringbuilder
		b81793.append(" SafeStuff"); // append some safe content
		b81793.replace(b81793.length()-"Chars".length(),b81793.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81793 = new java.util.HashMap<String,Object>();
		map81793.put("key81793", b81793.toString()); // put in a collection
		String c81793 = (String)map81793.get("key81793"); // get it back out
		String d81793 = c81793.substring(0,c81793.length()-1); // extract most of it
		String e81793 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81793.getBytes() ) )); // B64 encode and decode it
		String f81793 = e81793.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81793); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
