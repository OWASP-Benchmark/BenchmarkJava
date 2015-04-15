package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02325")
public class BenchmarkTest02325 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a62831 = param; //assign
		StringBuilder b62831 = new StringBuilder(a62831);  // stick in stringbuilder
		b62831.append(" SafeStuff"); // append some safe content
		b62831.replace(b62831.length()-"Chars".length(),b62831.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62831 = new java.util.HashMap<String,Object>();
		map62831.put("key62831", b62831.toString()); // put in a collection
		String c62831 = (String)map62831.get("key62831"); // get it back out
		String d62831 = c62831.substring(0,c62831.length()-1); // extract most of it
		String e62831 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62831.getBytes() ) )); // B64 encode and decode it
		String f62831 = e62831.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g62831 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g62831); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
