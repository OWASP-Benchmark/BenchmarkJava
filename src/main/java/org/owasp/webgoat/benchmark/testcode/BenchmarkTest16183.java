package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16183")
public class BenchmarkTest16183 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85479 = param; //assign
		StringBuilder b85479 = new StringBuilder(a85479);  // stick in stringbuilder
		b85479.append(" SafeStuff"); // append some safe content
		b85479.replace(b85479.length()-"Chars".length(),b85479.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85479 = new java.util.HashMap<String,Object>();
		map85479.put("key85479", b85479.toString()); // put in a collection
		String c85479 = (String)map85479.get("key85479"); // get it back out
		String d85479 = c85479.substring(0,c85479.length()-1); // extract most of it
		String e85479 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85479.getBytes() ) )); // B64 encode and decode it
		String f85479 = e85479.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g85479 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g85479); // reflection
	
		return bar;	
	}
}
