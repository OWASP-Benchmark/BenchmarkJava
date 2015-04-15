package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11478")
public class BenchmarkTest11478 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new String[] {"Column1","Column2"} );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75483 = param; //assign
		StringBuilder b75483 = new StringBuilder(a75483);  // stick in stringbuilder
		b75483.append(" SafeStuff"); // append some safe content
		b75483.replace(b75483.length()-"Chars".length(),b75483.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75483 = new java.util.HashMap<String,Object>();
		map75483.put("key75483", b75483.toString()); // put in a collection
		String c75483 = (String)map75483.get("key75483"); // get it back out
		String d75483 = c75483.substring(0,c75483.length()-1); // extract most of it
		String e75483 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75483.getBytes() ) )); // B64 encode and decode it
		String f75483 = e75483.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f75483); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
