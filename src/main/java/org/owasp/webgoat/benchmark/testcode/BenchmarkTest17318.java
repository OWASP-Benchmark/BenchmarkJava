package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17318")
public class BenchmarkTest17318 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a25865 = param; //assign
		StringBuilder b25865 = new StringBuilder(a25865);  // stick in stringbuilder
		b25865.append(" SafeStuff"); // append some safe content
		b25865.replace(b25865.length()-"Chars".length(),b25865.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25865 = new java.util.HashMap<String,Object>();
		map25865.put("key25865", b25865.toString()); // put in a collection
		String c25865 = (String)map25865.get("key25865"); // get it back out
		String d25865 = c25865.substring(0,c25865.length()-1); // extract most of it
		String e25865 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25865.getBytes() ) )); // B64 encode and decode it
		String f25865 = e25865.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25865); // reflection
	
		return bar;	
	}
}
