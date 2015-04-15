package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16178")
public class BenchmarkTest16178 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70244 = param; //assign
		StringBuilder b70244 = new StringBuilder(a70244);  // stick in stringbuilder
		b70244.append(" SafeStuff"); // append some safe content
		b70244.replace(b70244.length()-"Chars".length(),b70244.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70244 = new java.util.HashMap<String,Object>();
		map70244.put("key70244", b70244.toString()); // put in a collection
		String c70244 = (String)map70244.get("key70244"); // get it back out
		String d70244 = c70244.substring(0,c70244.length()-1); // extract most of it
		String e70244 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70244.getBytes() ) )); // B64 encode and decode it
		String f70244 = e70244.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70244 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70244); // reflection
	
		return bar;	
	}
}
