package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19794")
public class BenchmarkTest19794 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94625 = param; //assign
		StringBuilder b94625 = new StringBuilder(a94625);  // stick in stringbuilder
		b94625.append(" SafeStuff"); // append some safe content
		b94625.replace(b94625.length()-"Chars".length(),b94625.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94625 = new java.util.HashMap<String,Object>();
		map94625.put("key94625", b94625.toString()); // put in a collection
		String c94625 = (String)map94625.get("key94625"); // get it back out
		String d94625 = c94625.substring(0,c94625.length()-1); // extract most of it
		String e94625 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94625.getBytes() ) )); // B64 encode and decode it
		String f94625 = e94625.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94625); // reflection
	
		return bar;	
	}
}
