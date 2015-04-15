package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17934")
public class BenchmarkTest17934 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20793 = param; //assign
		StringBuilder b20793 = new StringBuilder(a20793);  // stick in stringbuilder
		b20793.append(" SafeStuff"); // append some safe content
		b20793.replace(b20793.length()-"Chars".length(),b20793.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20793 = new java.util.HashMap<String,Object>();
		map20793.put("key20793", b20793.toString()); // put in a collection
		String c20793 = (String)map20793.get("key20793"); // get it back out
		String d20793 = c20793.substring(0,c20793.length()-1); // extract most of it
		String e20793 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20793.getBytes() ) )); // B64 encode and decode it
		String f20793 = e20793.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g20793 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g20793); // reflection
	
		return bar;	
	}
}
