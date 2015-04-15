package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10246")
public class BenchmarkTest10246 extends HttpServlet {
	
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
		String a44697 = param; //assign
		StringBuilder b44697 = new StringBuilder(a44697);  // stick in stringbuilder
		b44697.append(" SafeStuff"); // append some safe content
		b44697.replace(b44697.length()-"Chars".length(),b44697.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44697 = new java.util.HashMap<String,Object>();
		map44697.put("key44697", b44697.toString()); // put in a collection
		String c44697 = (String)map44697.get("key44697"); // get it back out
		String d44697 = c44697.substring(0,c44697.length()-1); // extract most of it
		String e44697 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44697.getBytes() ) )); // B64 encode and decode it
		String f44697 = e44697.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g44697 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44697); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
