package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19841")
public class BenchmarkTest19841 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29466 = param; //assign
		StringBuilder b29466 = new StringBuilder(a29466);  // stick in stringbuilder
		b29466.append(" SafeStuff"); // append some safe content
		b29466.replace(b29466.length()-"Chars".length(),b29466.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29466 = new java.util.HashMap<String,Object>();
		map29466.put("key29466", b29466.toString()); // put in a collection
		String c29466 = (String)map29466.get("key29466"); // get it back out
		String d29466 = c29466.substring(0,c29466.length()-1); // extract most of it
		String e29466 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29466.getBytes() ) )); // B64 encode and decode it
		String f29466 = e29466.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29466); // reflection
	
		return bar;	
	}
}
