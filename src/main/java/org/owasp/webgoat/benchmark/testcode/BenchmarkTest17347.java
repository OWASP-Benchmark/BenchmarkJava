package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17347")
public class BenchmarkTest17347 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a81894 = param; //assign
		StringBuilder b81894 = new StringBuilder(a81894);  // stick in stringbuilder
		b81894.append(" SafeStuff"); // append some safe content
		b81894.replace(b81894.length()-"Chars".length(),b81894.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81894 = new java.util.HashMap<String,Object>();
		map81894.put("key81894", b81894.toString()); // put in a collection
		String c81894 = (String)map81894.get("key81894"); // get it back out
		String d81894 = c81894.substring(0,c81894.length()-1); // extract most of it
		String e81894 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81894.getBytes() ) )); // B64 encode and decode it
		String f81894 = e81894.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g81894 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g81894); // reflection
	
		return bar;	
	}
}
