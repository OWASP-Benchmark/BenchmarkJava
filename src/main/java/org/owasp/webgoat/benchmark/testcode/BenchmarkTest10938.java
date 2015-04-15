package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10938")
public class BenchmarkTest10938 extends HttpServlet {
	
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
			int count = statement.executeUpdate( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a17485 = param; //assign
		StringBuilder b17485 = new StringBuilder(a17485);  // stick in stringbuilder
		b17485.append(" SafeStuff"); // append some safe content
		b17485.replace(b17485.length()-"Chars".length(),b17485.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17485 = new java.util.HashMap<String,Object>();
		map17485.put("key17485", b17485.toString()); // put in a collection
		String c17485 = (String)map17485.get("key17485"); // get it back out
		String d17485 = c17485.substring(0,c17485.length()-1); // extract most of it
		String e17485 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17485.getBytes() ) )); // B64 encode and decode it
		String f17485 = e17485.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f17485); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
