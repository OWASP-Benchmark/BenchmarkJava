package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13332")
public class BenchmarkTest13332 extends HttpServlet {
	
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
		String a46388 = param; //assign
		StringBuilder b46388 = new StringBuilder(a46388);  // stick in stringbuilder
		b46388.append(" SafeStuff"); // append some safe content
		b46388.replace(b46388.length()-"Chars".length(),b46388.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46388 = new java.util.HashMap<String,Object>();
		map46388.put("key46388", b46388.toString()); // put in a collection
		String c46388 = (String)map46388.get("key46388"); // get it back out
		String d46388 = c46388.substring(0,c46388.length()-1); // extract most of it
		String e46388 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46388.getBytes() ) )); // B64 encode and decode it
		String f46388 = e46388.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f46388); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
