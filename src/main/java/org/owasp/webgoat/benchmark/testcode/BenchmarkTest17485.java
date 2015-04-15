package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17485")
public class BenchmarkTest17485 extends HttpServlet {
	
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
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93811 = param; //assign
		StringBuilder b93811 = new StringBuilder(a93811);  // stick in stringbuilder
		b93811.append(" SafeStuff"); // append some safe content
		b93811.replace(b93811.length()-"Chars".length(),b93811.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93811 = new java.util.HashMap<String,Object>();
		map93811.put("key93811", b93811.toString()); // put in a collection
		String c93811 = (String)map93811.get("key93811"); // get it back out
		String d93811 = c93811.substring(0,c93811.length()-1); // extract most of it
		String e93811 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93811.getBytes() ) )); // B64 encode and decode it
		String f93811 = e93811.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93811 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93811); // reflection
	
		return bar;	
	}
}
