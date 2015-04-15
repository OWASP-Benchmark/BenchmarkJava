package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16054")
public class BenchmarkTest16054 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a54854 = param; //assign
		StringBuilder b54854 = new StringBuilder(a54854);  // stick in stringbuilder
		b54854.append(" SafeStuff"); // append some safe content
		b54854.replace(b54854.length()-"Chars".length(),b54854.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54854 = new java.util.HashMap<String,Object>();
		map54854.put("key54854", b54854.toString()); // put in a collection
		String c54854 = (String)map54854.get("key54854"); // get it back out
		String d54854 = c54854.substring(0,c54854.length()-1); // extract most of it
		String e54854 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54854.getBytes() ) )); // B64 encode and decode it
		String f54854 = e54854.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54854); // reflection
	
		return bar;	
	}
}
