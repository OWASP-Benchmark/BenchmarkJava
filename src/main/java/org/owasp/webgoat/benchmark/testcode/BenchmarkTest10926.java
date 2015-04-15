package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10926")
public class BenchmarkTest10926 extends HttpServlet {
	
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
		String a62070 = param; //assign
		StringBuilder b62070 = new StringBuilder(a62070);  // stick in stringbuilder
		b62070.append(" SafeStuff"); // append some safe content
		b62070.replace(b62070.length()-"Chars".length(),b62070.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62070 = new java.util.HashMap<String,Object>();
		map62070.put("key62070", b62070.toString()); // put in a collection
		String c62070 = (String)map62070.get("key62070"); // get it back out
		String d62070 = c62070.substring(0,c62070.length()-1); // extract most of it
		String e62070 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62070.getBytes() ) )); // B64 encode and decode it
		String f62070 = e62070.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62070); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
