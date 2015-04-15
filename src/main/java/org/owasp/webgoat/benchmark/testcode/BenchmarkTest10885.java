package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10885")
public class BenchmarkTest10885 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new int[] { 1, 2 } );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a41096 = param; //assign
		StringBuilder b41096 = new StringBuilder(a41096);  // stick in stringbuilder
		b41096.append(" SafeStuff"); // append some safe content
		b41096.replace(b41096.length()-"Chars".length(),b41096.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41096 = new java.util.HashMap<String,Object>();
		map41096.put("key41096", b41096.toString()); // put in a collection
		String c41096 = (String)map41096.get("key41096"); // get it back out
		String d41096 = c41096.substring(0,c41096.length()-1); // extract most of it
		String e41096 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41096.getBytes() ) )); // B64 encode and decode it
		String f41096 = e41096.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41096); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
