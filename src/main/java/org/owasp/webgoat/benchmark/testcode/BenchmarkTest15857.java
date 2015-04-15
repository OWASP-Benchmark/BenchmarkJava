package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15857")
public class BenchmarkTest15857 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61920 = param; //assign
		StringBuilder b61920 = new StringBuilder(a61920);  // stick in stringbuilder
		b61920.append(" SafeStuff"); // append some safe content
		b61920.replace(b61920.length()-"Chars".length(),b61920.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61920 = new java.util.HashMap<String,Object>();
		map61920.put("key61920", b61920.toString()); // put in a collection
		String c61920 = (String)map61920.get("key61920"); // get it back out
		String d61920 = c61920.substring(0,c61920.length()-1); // extract most of it
		String e61920 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61920.getBytes() ) )); // B64 encode and decode it
		String f61920 = e61920.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61920 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61920); // reflection
	
		return bar;	
	}
}
