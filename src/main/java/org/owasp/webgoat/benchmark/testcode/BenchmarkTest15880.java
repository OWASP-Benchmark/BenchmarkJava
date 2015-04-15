package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15880")
public class BenchmarkTest15880 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83740 = param; //assign
		StringBuilder b83740 = new StringBuilder(a83740);  // stick in stringbuilder
		b83740.append(" SafeStuff"); // append some safe content
		b83740.replace(b83740.length()-"Chars".length(),b83740.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83740 = new java.util.HashMap<String,Object>();
		map83740.put("key83740", b83740.toString()); // put in a collection
		String c83740 = (String)map83740.get("key83740"); // get it back out
		String d83740 = c83740.substring(0,c83740.length()-1); // extract most of it
		String e83740 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83740.getBytes() ) )); // B64 encode and decode it
		String f83740 = e83740.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83740 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83740); // reflection
	
		return bar;	
	}
}
