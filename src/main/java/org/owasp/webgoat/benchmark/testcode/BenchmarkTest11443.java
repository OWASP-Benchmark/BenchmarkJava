package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11443")
public class BenchmarkTest11443 extends HttpServlet {
	
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
		String a80579 = param; //assign
		StringBuilder b80579 = new StringBuilder(a80579);  // stick in stringbuilder
		b80579.append(" SafeStuff"); // append some safe content
		b80579.replace(b80579.length()-"Chars".length(),b80579.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80579 = new java.util.HashMap<String,Object>();
		map80579.put("key80579", b80579.toString()); // put in a collection
		String c80579 = (String)map80579.get("key80579"); // get it back out
		String d80579 = c80579.substring(0,c80579.length()-1); // extract most of it
		String e80579 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80579.getBytes() ) )); // B64 encode and decode it
		String f80579 = e80579.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f80579); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
