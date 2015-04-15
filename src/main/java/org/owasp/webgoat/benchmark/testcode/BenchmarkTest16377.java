package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16377")
public class BenchmarkTest16377 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58953 = param; //assign
		StringBuilder b58953 = new StringBuilder(a58953);  // stick in stringbuilder
		b58953.append(" SafeStuff"); // append some safe content
		b58953.replace(b58953.length()-"Chars".length(),b58953.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58953 = new java.util.HashMap<String,Object>();
		map58953.put("key58953", b58953.toString()); // put in a collection
		String c58953 = (String)map58953.get("key58953"); // get it back out
		String d58953 = c58953.substring(0,c58953.length()-1); // extract most of it
		String e58953 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58953.getBytes() ) )); // B64 encode and decode it
		String f58953 = e58953.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g58953 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g58953); // reflection
	
		return bar;	
	}
}
