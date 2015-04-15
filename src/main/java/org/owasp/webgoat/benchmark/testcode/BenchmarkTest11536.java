package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11536")
public class BenchmarkTest11536 extends HttpServlet {
	
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
		String a24251 = param; //assign
		StringBuilder b24251 = new StringBuilder(a24251);  // stick in stringbuilder
		b24251.append(" SafeStuff"); // append some safe content
		b24251.replace(b24251.length()-"Chars".length(),b24251.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24251 = new java.util.HashMap<String,Object>();
		map24251.put("key24251", b24251.toString()); // put in a collection
		String c24251 = (String)map24251.get("key24251"); // get it back out
		String d24251 = c24251.substring(0,c24251.length()-1); // extract most of it
		String e24251 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24251.getBytes() ) )); // B64 encode and decode it
		String f24251 = e24251.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24251); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
