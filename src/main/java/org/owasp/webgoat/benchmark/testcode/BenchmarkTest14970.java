package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14970")
public class BenchmarkTest14970 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76290 = param; //assign
		StringBuilder b76290 = new StringBuilder(a76290);  // stick in stringbuilder
		b76290.append(" SafeStuff"); // append some safe content
		b76290.replace(b76290.length()-"Chars".length(),b76290.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76290 = new java.util.HashMap<String,Object>();
		map76290.put("key76290", b76290.toString()); // put in a collection
		String c76290 = (String)map76290.get("key76290"); // get it back out
		String d76290 = c76290.substring(0,c76290.length()-1); // extract most of it
		String e76290 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76290.getBytes() ) )); // B64 encode and decode it
		String f76290 = e76290.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76290); // reflection
	
		return bar;	
	}
}
