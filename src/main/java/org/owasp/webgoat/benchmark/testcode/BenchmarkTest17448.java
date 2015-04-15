package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17448")
public class BenchmarkTest17448 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51264 = param; //assign
		StringBuilder b51264 = new StringBuilder(a51264);  // stick in stringbuilder
		b51264.append(" SafeStuff"); // append some safe content
		b51264.replace(b51264.length()-"Chars".length(),b51264.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51264 = new java.util.HashMap<String,Object>();
		map51264.put("key51264", b51264.toString()); // put in a collection
		String c51264 = (String)map51264.get("key51264"); // get it back out
		String d51264 = c51264.substring(0,c51264.length()-1); // extract most of it
		String e51264 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51264.getBytes() ) )); // B64 encode and decode it
		String f51264 = e51264.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51264 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51264); // reflection
	
		return bar;	
	}
}
