package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11565")
public class BenchmarkTest11565 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44999 = param; //assign
		StringBuilder b44999 = new StringBuilder(a44999);  // stick in stringbuilder
		b44999.append(" SafeStuff"); // append some safe content
		b44999.replace(b44999.length()-"Chars".length(),b44999.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44999 = new java.util.HashMap<String,Object>();
		map44999.put("key44999", b44999.toString()); // put in a collection
		String c44999 = (String)map44999.get("key44999"); // get it back out
		String d44999 = c44999.substring(0,c44999.length()-1); // extract most of it
		String e44999 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44999.getBytes() ) )); // B64 encode and decode it
		String f44999 = e44999.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g44999 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44999); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
