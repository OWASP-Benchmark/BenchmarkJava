package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17570")
public class BenchmarkTest17570 extends HttpServlet {
	
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
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92650 = param; //assign
		StringBuilder b92650 = new StringBuilder(a92650);  // stick in stringbuilder
		b92650.append(" SafeStuff"); // append some safe content
		b92650.replace(b92650.length()-"Chars".length(),b92650.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92650 = new java.util.HashMap<String,Object>();
		map92650.put("key92650", b92650.toString()); // put in a collection
		String c92650 = (String)map92650.get("key92650"); // get it back out
		String d92650 = c92650.substring(0,c92650.length()-1); // extract most of it
		String e92650 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92650.getBytes() ) )); // B64 encode and decode it
		String f92650 = e92650.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92650 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92650); // reflection
	
		return bar;	
	}
}
