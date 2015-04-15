package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15635")
public class BenchmarkTest15635 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93861 = param; //assign
		StringBuilder b93861 = new StringBuilder(a93861);  // stick in stringbuilder
		b93861.append(" SafeStuff"); // append some safe content
		b93861.replace(b93861.length()-"Chars".length(),b93861.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93861 = new java.util.HashMap<String,Object>();
		map93861.put("key93861", b93861.toString()); // put in a collection
		String c93861 = (String)map93861.get("key93861"); // get it back out
		String d93861 = c93861.substring(0,c93861.length()-1); // extract most of it
		String e93861 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93861.getBytes() ) )); // B64 encode and decode it
		String f93861 = e93861.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93861 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93861); // reflection
	
		return bar;	
	}
}
