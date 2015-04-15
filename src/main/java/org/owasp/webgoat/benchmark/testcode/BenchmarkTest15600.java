package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15600")
public class BenchmarkTest15600 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94325 = param; //assign
		StringBuilder b94325 = new StringBuilder(a94325);  // stick in stringbuilder
		b94325.append(" SafeStuff"); // append some safe content
		b94325.replace(b94325.length()-"Chars".length(),b94325.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94325 = new java.util.HashMap<String,Object>();
		map94325.put("key94325", b94325.toString()); // put in a collection
		String c94325 = (String)map94325.get("key94325"); // get it back out
		String d94325 = c94325.substring(0,c94325.length()-1); // extract most of it
		String e94325 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94325.getBytes() ) )); // B64 encode and decode it
		String f94325 = e94325.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g94325 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94325); // reflection
	
		return bar;	
	}
}
