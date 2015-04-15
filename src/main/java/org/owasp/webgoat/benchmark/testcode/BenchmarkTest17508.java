package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17508")
public class BenchmarkTest17508 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34061 = param; //assign
		StringBuilder b34061 = new StringBuilder(a34061);  // stick in stringbuilder
		b34061.append(" SafeStuff"); // append some safe content
		b34061.replace(b34061.length()-"Chars".length(),b34061.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34061 = new java.util.HashMap<String,Object>();
		map34061.put("key34061", b34061.toString()); // put in a collection
		String c34061 = (String)map34061.get("key34061"); // get it back out
		String d34061 = c34061.substring(0,c34061.length()-1); // extract most of it
		String e34061 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34061.getBytes() ) )); // B64 encode and decode it
		String f34061 = e34061.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g34061 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34061); // reflection
	
		return bar;	
	}
}
