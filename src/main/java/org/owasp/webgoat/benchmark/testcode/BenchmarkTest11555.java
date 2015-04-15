package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11555")
public class BenchmarkTest11555 extends HttpServlet {
	
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
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new String[] {"user","password"} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6181 = param; //assign
		StringBuilder b6181 = new StringBuilder(a6181);  // stick in stringbuilder
		b6181.append(" SafeStuff"); // append some safe content
		b6181.replace(b6181.length()-"Chars".length(),b6181.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6181 = new java.util.HashMap<String,Object>();
		map6181.put("key6181", b6181.toString()); // put in a collection
		String c6181 = (String)map6181.get("key6181"); // get it back out
		String d6181 = c6181.substring(0,c6181.length()-1); // extract most of it
		String e6181 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6181.getBytes() ) )); // B64 encode and decode it
		String f6181 = e6181.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6181); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
