package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08330")
public class BenchmarkTest08330 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38753 = param; //assign
		StringBuilder b38753 = new StringBuilder(a38753);  // stick in stringbuilder
		b38753.append(" SafeStuff"); // append some safe content
		b38753.replace(b38753.length()-"Chars".length(),b38753.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38753 = new java.util.HashMap<String,Object>();
		map38753.put("key38753", b38753.toString()); // put in a collection
		String c38753 = (String)map38753.get("key38753"); // get it back out
		String d38753 = c38753.substring(0,c38753.length()-1); // extract most of it
		String e38753 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38753.getBytes() ) )); // B64 encode and decode it
		String f38753 = e38753.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38753); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
