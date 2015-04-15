package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17320")
public class BenchmarkTest17320 extends HttpServlet {
	
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
		String a82413 = param; //assign
		StringBuilder b82413 = new StringBuilder(a82413);  // stick in stringbuilder
		b82413.append(" SafeStuff"); // append some safe content
		b82413.replace(b82413.length()-"Chars".length(),b82413.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82413 = new java.util.HashMap<String,Object>();
		map82413.put("key82413", b82413.toString()); // put in a collection
		String c82413 = (String)map82413.get("key82413"); // get it back out
		String d82413 = c82413.substring(0,c82413.length()-1); // extract most of it
		String e82413 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82413.getBytes() ) )); // B64 encode and decode it
		String f82413 = e82413.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g82413 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82413); // reflection
	
		return bar;	
	}
}
