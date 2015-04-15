package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10301")
public class BenchmarkTest10301 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9310 = param; //assign
		StringBuilder b9310 = new StringBuilder(a9310);  // stick in stringbuilder
		b9310.append(" SafeStuff"); // append some safe content
		b9310.replace(b9310.length()-"Chars".length(),b9310.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9310 = new java.util.HashMap<String,Object>();
		map9310.put("key9310", b9310.toString()); // put in a collection
		String c9310 = (String)map9310.get("key9310"); // get it back out
		String d9310 = c9310.substring(0,c9310.length()-1); // extract most of it
		String e9310 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9310.getBytes() ) )); // B64 encode and decode it
		String f9310 = e9310.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9310); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
