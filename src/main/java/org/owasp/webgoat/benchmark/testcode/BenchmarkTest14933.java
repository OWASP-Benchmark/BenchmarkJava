package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14933")
public class BenchmarkTest14933 extends HttpServlet {
	
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
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24589 = param; //assign
		StringBuilder b24589 = new StringBuilder(a24589);  // stick in stringbuilder
		b24589.append(" SafeStuff"); // append some safe content
		b24589.replace(b24589.length()-"Chars".length(),b24589.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24589 = new java.util.HashMap<String,Object>();
		map24589.put("key24589", b24589.toString()); // put in a collection
		String c24589 = (String)map24589.get("key24589"); // get it back out
		String d24589 = c24589.substring(0,c24589.length()-1); // extract most of it
		String e24589 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24589.getBytes() ) )); // B64 encode and decode it
		String f24589 = e24589.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24589); // reflection
	
		return bar;	
	}
}
