package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15409")
public class BenchmarkTest15409 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43561 = param; //assign
		StringBuilder b43561 = new StringBuilder(a43561);  // stick in stringbuilder
		b43561.append(" SafeStuff"); // append some safe content
		b43561.replace(b43561.length()-"Chars".length(),b43561.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43561 = new java.util.HashMap<String,Object>();
		map43561.put("key43561", b43561.toString()); // put in a collection
		String c43561 = (String)map43561.get("key43561"); // get it back out
		String d43561 = c43561.substring(0,c43561.length()-1); // extract most of it
		String e43561 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43561.getBytes() ) )); // B64 encode and decode it
		String f43561 = e43561.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f43561); // reflection
	
		return bar;	
	}
}
