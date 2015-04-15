package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13380")
public class BenchmarkTest13380 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10482 = param; //assign
		StringBuilder b10482 = new StringBuilder(a10482);  // stick in stringbuilder
		b10482.append(" SafeStuff"); // append some safe content
		b10482.replace(b10482.length()-"Chars".length(),b10482.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10482 = new java.util.HashMap<String,Object>();
		map10482.put("key10482", b10482.toString()); // put in a collection
		String c10482 = (String)map10482.get("key10482"); // get it back out
		String d10482 = c10482.substring(0,c10482.length()-1); // extract most of it
		String e10482 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10482.getBytes() ) )); // B64 encode and decode it
		String f10482 = e10482.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10482); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
