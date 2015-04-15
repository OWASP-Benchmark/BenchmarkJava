package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02743")
public class BenchmarkTest02743 extends HttpServlet {
	
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
		String a77556 = param; //assign
		StringBuilder b77556 = new StringBuilder(a77556);  // stick in stringbuilder
		b77556.append(" SafeStuff"); // append some safe content
		b77556.replace(b77556.length()-"Chars".length(),b77556.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77556 = new java.util.HashMap<String,Object>();
		map77556.put("key77556", b77556.toString()); // put in a collection
		String c77556 = (String)map77556.get("key77556"); // get it back out
		String d77556 = c77556.substring(0,c77556.length()-1); // extract most of it
		String e77556 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77556.getBytes() ) )); // B64 encode and decode it
		String f77556 = e77556.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77556); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
