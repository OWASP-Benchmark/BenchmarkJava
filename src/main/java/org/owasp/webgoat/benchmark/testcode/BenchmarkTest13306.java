package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13306")
public class BenchmarkTest13306 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a13858 = param; //assign
		StringBuilder b13858 = new StringBuilder(a13858);  // stick in stringbuilder
		b13858.append(" SafeStuff"); // append some safe content
		b13858.replace(b13858.length()-"Chars".length(),b13858.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13858 = new java.util.HashMap<String,Object>();
		map13858.put("key13858", b13858.toString()); // put in a collection
		String c13858 = (String)map13858.get("key13858"); // get it back out
		String d13858 = c13858.substring(0,c13858.length()-1); // extract most of it
		String e13858 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13858.getBytes() ) )); // B64 encode and decode it
		String f13858 = e13858.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13858); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
