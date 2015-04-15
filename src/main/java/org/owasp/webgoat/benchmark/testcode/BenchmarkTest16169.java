package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16169")
public class BenchmarkTest16169 extends HttpServlet {
	
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
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1620 = param; //assign
		StringBuilder b1620 = new StringBuilder(a1620);  // stick in stringbuilder
		b1620.append(" SafeStuff"); // append some safe content
		b1620.replace(b1620.length()-"Chars".length(),b1620.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1620 = new java.util.HashMap<String,Object>();
		map1620.put("key1620", b1620.toString()); // put in a collection
		String c1620 = (String)map1620.get("key1620"); // get it back out
		String d1620 = c1620.substring(0,c1620.length()-1); // extract most of it
		String e1620 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1620.getBytes() ) )); // B64 encode and decode it
		String f1620 = e1620.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1620 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1620); // reflection
	
		return bar;	
	}
}
