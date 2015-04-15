package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15207")
public class BenchmarkTest15207 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27248 = param; //assign
		StringBuilder b27248 = new StringBuilder(a27248);  // stick in stringbuilder
		b27248.append(" SafeStuff"); // append some safe content
		b27248.replace(b27248.length()-"Chars".length(),b27248.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27248 = new java.util.HashMap<String,Object>();
		map27248.put("key27248", b27248.toString()); // put in a collection
		String c27248 = (String)map27248.get("key27248"); // get it back out
		String d27248 = c27248.substring(0,c27248.length()-1); // extract most of it
		String e27248 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27248.getBytes() ) )); // B64 encode and decode it
		String f27248 = e27248.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g27248 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g27248); // reflection
	
		return bar;	
	}
}
