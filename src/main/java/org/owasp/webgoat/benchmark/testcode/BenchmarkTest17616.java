package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17616")
public class BenchmarkTest17616 extends HttpServlet {
	
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
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51645 = param; //assign
		StringBuilder b51645 = new StringBuilder(a51645);  // stick in stringbuilder
		b51645.append(" SafeStuff"); // append some safe content
		b51645.replace(b51645.length()-"Chars".length(),b51645.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51645 = new java.util.HashMap<String,Object>();
		map51645.put("key51645", b51645.toString()); // put in a collection
		String c51645 = (String)map51645.get("key51645"); // get it back out
		String d51645 = c51645.substring(0,c51645.length()-1); // extract most of it
		String e51645 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51645.getBytes() ) )); // B64 encode and decode it
		String f51645 = e51645.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51645 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51645); // reflection
	
		return bar;	
	}
}
