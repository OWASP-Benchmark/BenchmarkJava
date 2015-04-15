package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09683")
public class BenchmarkTest09683 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
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
		String a55161 = param; //assign
		StringBuilder b55161 = new StringBuilder(a55161);  // stick in stringbuilder
		b55161.append(" SafeStuff"); // append some safe content
		b55161.replace(b55161.length()-"Chars".length(),b55161.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55161 = new java.util.HashMap<String,Object>();
		map55161.put("key55161", b55161.toString()); // put in a collection
		String c55161 = (String)map55161.get("key55161"); // get it back out
		String d55161 = c55161.substring(0,c55161.length()-1); // extract most of it
		String e55161 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55161.getBytes() ) )); // B64 encode and decode it
		String f55161 = e55161.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f55161); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
