package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10212")
public class BenchmarkTest10212 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql );
		    statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88324 = param; //assign
		StringBuilder b88324 = new StringBuilder(a88324);  // stick in stringbuilder
		b88324.append(" SafeStuff"); // append some safe content
		b88324.replace(b88324.length()-"Chars".length(),b88324.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88324 = new java.util.HashMap<String,Object>();
		map88324.put("key88324", b88324.toString()); // put in a collection
		String c88324 = (String)map88324.get("key88324"); // get it back out
		String d88324 = c88324.substring(0,c88324.length()-1); // extract most of it
		String e88324 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88324.getBytes() ) )); // B64 encode and decode it
		String f88324 = e88324.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88324 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88324); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
