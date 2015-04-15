package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15633")
public class BenchmarkTest15633 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14019 = param; //assign
		StringBuilder b14019 = new StringBuilder(a14019);  // stick in stringbuilder
		b14019.append(" SafeStuff"); // append some safe content
		b14019.replace(b14019.length()-"Chars".length(),b14019.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14019 = new java.util.HashMap<String,Object>();
		map14019.put("key14019", b14019.toString()); // put in a collection
		String c14019 = (String)map14019.get("key14019"); // get it back out
		String d14019 = c14019.substring(0,c14019.length()-1); // extract most of it
		String e14019 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14019.getBytes() ) )); // B64 encode and decode it
		String f14019 = e14019.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14019); // reflection
	
		return bar;	
	}
}
