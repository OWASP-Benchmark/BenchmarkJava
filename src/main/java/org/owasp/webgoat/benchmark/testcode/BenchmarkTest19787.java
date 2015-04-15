package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19787")
public class BenchmarkTest19787 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10723 = param; //assign
		StringBuilder b10723 = new StringBuilder(a10723);  // stick in stringbuilder
		b10723.append(" SafeStuff"); // append some safe content
		b10723.replace(b10723.length()-"Chars".length(),b10723.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10723 = new java.util.HashMap<String,Object>();
		map10723.put("key10723", b10723.toString()); // put in a collection
		String c10723 = (String)map10723.get("key10723"); // get it back out
		String d10723 = c10723.substring(0,c10723.length()-1); // extract most of it
		String e10723 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10723.getBytes() ) )); // B64 encode and decode it
		String f10723 = e10723.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10723); // reflection
	
		return bar;	
	}
}
