package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01437")
public class BenchmarkTest01437 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a94952 = param; //assign
		StringBuilder b94952 = new StringBuilder(a94952);  // stick in stringbuilder
		b94952.append(" SafeStuff"); // append some safe content
		b94952.replace(b94952.length()-"Chars".length(),b94952.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94952 = new java.util.HashMap<String,Object>();
		map94952.put("key94952", b94952.toString()); // put in a collection
		String c94952 = (String)map94952.get("key94952"); // get it back out
		String d94952 = c94952.substring(0,c94952.length()-1); // extract most of it
		String e94952 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94952.getBytes() ) )); // B64 encode and decode it
		String f94952 = e94952.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g94952 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94952); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
