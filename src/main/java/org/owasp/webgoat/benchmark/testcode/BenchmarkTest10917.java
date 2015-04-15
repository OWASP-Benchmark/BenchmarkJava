package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10917")
public class BenchmarkTest10917 extends HttpServlet {
	
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
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a59995 = param; //assign
		StringBuilder b59995 = new StringBuilder(a59995);  // stick in stringbuilder
		b59995.append(" SafeStuff"); // append some safe content
		b59995.replace(b59995.length()-"Chars".length(),b59995.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59995 = new java.util.HashMap<String,Object>();
		map59995.put("key59995", b59995.toString()); // put in a collection
		String c59995 = (String)map59995.get("key59995"); // get it back out
		String d59995 = c59995.substring(0,c59995.length()-1); // extract most of it
		String e59995 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59995.getBytes() ) )); // B64 encode and decode it
		String f59995 = e59995.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g59995 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59995); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
