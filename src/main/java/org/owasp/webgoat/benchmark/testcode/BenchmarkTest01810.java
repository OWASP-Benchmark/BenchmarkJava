package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01810")
public class BenchmarkTest01810 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a99121 = param; //assign
		StringBuilder b99121 = new StringBuilder(a99121);  // stick in stringbuilder
		b99121.append(" SafeStuff"); // append some safe content
		b99121.replace(b99121.length()-"Chars".length(),b99121.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99121 = new java.util.HashMap<String,Object>();
		map99121.put("key99121", b99121.toString()); // put in a collection
		String c99121 = (String)map99121.get("key99121"); // get it back out
		String d99121 = c99121.substring(0,c99121.length()-1); // extract most of it
		String e99121 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99121.getBytes() ) )); // B64 encode and decode it
		String f99121 = e99121.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g99121 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g99121); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
