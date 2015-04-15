package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16247")
public class BenchmarkTest16247 extends HttpServlet {
	
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
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10516 = param; //assign
		StringBuilder b10516 = new StringBuilder(a10516);  // stick in stringbuilder
		b10516.append(" SafeStuff"); // append some safe content
		b10516.replace(b10516.length()-"Chars".length(),b10516.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10516 = new java.util.HashMap<String,Object>();
		map10516.put("key10516", b10516.toString()); // put in a collection
		String c10516 = (String)map10516.get("key10516"); // get it back out
		String d10516 = c10516.substring(0,c10516.length()-1); // extract most of it
		String e10516 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10516.getBytes() ) )); // B64 encode and decode it
		String f10516 = e10516.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10516); // reflection
	
		return bar;	
	}
}
