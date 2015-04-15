package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09651")
public class BenchmarkTest09651 extends HttpServlet {
	
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
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a25950 = param; //assign
		StringBuilder b25950 = new StringBuilder(a25950);  // stick in stringbuilder
		b25950.append(" SafeStuff"); // append some safe content
		b25950.replace(b25950.length()-"Chars".length(),b25950.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25950 = new java.util.HashMap<String,Object>();
		map25950.put("key25950", b25950.toString()); // put in a collection
		String c25950 = (String)map25950.get("key25950"); // get it back out
		String d25950 = c25950.substring(0,c25950.length()-1); // extract most of it
		String e25950 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25950.getBytes() ) )); // B64 encode and decode it
		String f25950 = e25950.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g25950 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g25950); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
