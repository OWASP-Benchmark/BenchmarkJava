package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09034")
public class BenchmarkTest09034 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
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
		String a27676 = param; //assign
		StringBuilder b27676 = new StringBuilder(a27676);  // stick in stringbuilder
		b27676.append(" SafeStuff"); // append some safe content
		b27676.replace(b27676.length()-"Chars".length(),b27676.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27676 = new java.util.HashMap<String,Object>();
		map27676.put("key27676", b27676.toString()); // put in a collection
		String c27676 = (String)map27676.get("key27676"); // get it back out
		String d27676 = c27676.substring(0,c27676.length()-1); // extract most of it
		String e27676 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27676.getBytes() ) )); // B64 encode and decode it
		String f27676 = e27676.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27676); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
