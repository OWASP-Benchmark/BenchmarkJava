package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09691")
public class BenchmarkTest09691 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11005 = param; //assign
		StringBuilder b11005 = new StringBuilder(a11005);  // stick in stringbuilder
		b11005.append(" SafeStuff"); // append some safe content
		b11005.replace(b11005.length()-"Chars".length(),b11005.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11005 = new java.util.HashMap<String,Object>();
		map11005.put("key11005", b11005.toString()); // put in a collection
		String c11005 = (String)map11005.get("key11005"); // get it back out
		String d11005 = c11005.substring(0,c11005.length()-1); // extract most of it
		String e11005 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11005.getBytes() ) )); // B64 encode and decode it
		String f11005 = e11005.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f11005); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
