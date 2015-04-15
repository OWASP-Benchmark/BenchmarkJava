package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18124")
public class BenchmarkTest18124 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
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
		String a45397 = param; //assign
		StringBuilder b45397 = new StringBuilder(a45397);  // stick in stringbuilder
		b45397.append(" SafeStuff"); // append some safe content
		b45397.replace(b45397.length()-"Chars".length(),b45397.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45397 = new java.util.HashMap<String,Object>();
		map45397.put("key45397", b45397.toString()); // put in a collection
		String c45397 = (String)map45397.get("key45397"); // get it back out
		String d45397 = c45397.substring(0,c45397.length()-1); // extract most of it
		String e45397 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45397.getBytes() ) )); // B64 encode and decode it
		String f45397 = e45397.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45397); // reflection
	
		return bar;	
	}
}
