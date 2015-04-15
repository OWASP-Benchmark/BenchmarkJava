package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11540")
public class BenchmarkTest11540 extends HttpServlet {
	
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
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3185 = param; //assign
		StringBuilder b3185 = new StringBuilder(a3185);  // stick in stringbuilder
		b3185.append(" SafeStuff"); // append some safe content
		b3185.replace(b3185.length()-"Chars".length(),b3185.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3185 = new java.util.HashMap<String,Object>();
		map3185.put("key3185", b3185.toString()); // put in a collection
		String c3185 = (String)map3185.get("key3185"); // get it back out
		String d3185 = c3185.substring(0,c3185.length()-1); // extract most of it
		String e3185 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3185.getBytes() ) )); // B64 encode and decode it
		String f3185 = e3185.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g3185 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g3185); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
