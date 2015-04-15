package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15606")
public class BenchmarkTest15606 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21672 = param; //assign
		StringBuilder b21672 = new StringBuilder(a21672);  // stick in stringbuilder
		b21672.append(" SafeStuff"); // append some safe content
		b21672.replace(b21672.length()-"Chars".length(),b21672.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21672 = new java.util.HashMap<String,Object>();
		map21672.put("key21672", b21672.toString()); // put in a collection
		String c21672 = (String)map21672.get("key21672"); // get it back out
		String d21672 = c21672.substring(0,c21672.length()-1); // extract most of it
		String e21672 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21672.getBytes() ) )); // B64 encode and decode it
		String f21672 = e21672.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21672); // reflection
	
		return bar;	
	}
}
