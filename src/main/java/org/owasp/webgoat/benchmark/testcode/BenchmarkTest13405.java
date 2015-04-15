package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13405")
public class BenchmarkTest13405 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a84096 = param; //assign
		StringBuilder b84096 = new StringBuilder(a84096);  // stick in stringbuilder
		b84096.append(" SafeStuff"); // append some safe content
		b84096.replace(b84096.length()-"Chars".length(),b84096.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84096 = new java.util.HashMap<String,Object>();
		map84096.put("key84096", b84096.toString()); // put in a collection
		String c84096 = (String)map84096.get("key84096"); // get it back out
		String d84096 = c84096.substring(0,c84096.length()-1); // extract most of it
		String e84096 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84096.getBytes() ) )); // B64 encode and decode it
		String f84096 = e84096.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84096 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84096); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
