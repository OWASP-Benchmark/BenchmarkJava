package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10199")
public class BenchmarkTest10199 extends HttpServlet {
	
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
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68436 = param; //assign
		StringBuilder b68436 = new StringBuilder(a68436);  // stick in stringbuilder
		b68436.append(" SafeStuff"); // append some safe content
		b68436.replace(b68436.length()-"Chars".length(),b68436.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68436 = new java.util.HashMap<String,Object>();
		map68436.put("key68436", b68436.toString()); // put in a collection
		String c68436 = (String)map68436.get("key68436"); // get it back out
		String d68436 = c68436.substring(0,c68436.length()-1); // extract most of it
		String e68436 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68436.getBytes() ) )); // B64 encode and decode it
		String f68436 = e68436.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68436); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
