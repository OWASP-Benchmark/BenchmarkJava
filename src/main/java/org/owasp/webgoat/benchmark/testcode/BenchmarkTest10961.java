package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10961")
public class BenchmarkTest10961 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35340 = param; //assign
		StringBuilder b35340 = new StringBuilder(a35340);  // stick in stringbuilder
		b35340.append(" SafeStuff"); // append some safe content
		b35340.replace(b35340.length()-"Chars".length(),b35340.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35340 = new java.util.HashMap<String,Object>();
		map35340.put("key35340", b35340.toString()); // put in a collection
		String c35340 = (String)map35340.get("key35340"); // get it back out
		String d35340 = c35340.substring(0,c35340.length()-1); // extract most of it
		String e35340 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35340.getBytes() ) )); // B64 encode and decode it
		String f35340 = e35340.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35340 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35340); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
