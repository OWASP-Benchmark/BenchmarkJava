package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10948")
public class BenchmarkTest10948 extends HttpServlet {
	
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
		String a48242 = param; //assign
		StringBuilder b48242 = new StringBuilder(a48242);  // stick in stringbuilder
		b48242.append(" SafeStuff"); // append some safe content
		b48242.replace(b48242.length()-"Chars".length(),b48242.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48242 = new java.util.HashMap<String,Object>();
		map48242.put("key48242", b48242.toString()); // put in a collection
		String c48242 = (String)map48242.get("key48242"); // get it back out
		String d48242 = c48242.substring(0,c48242.length()-1); // extract most of it
		String e48242 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48242.getBytes() ) )); // B64 encode and decode it
		String f48242 = e48242.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48242); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
