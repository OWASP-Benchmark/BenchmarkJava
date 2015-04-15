package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18049")
public class BenchmarkTest18049 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31686 = param; //assign
		StringBuilder b31686 = new StringBuilder(a31686);  // stick in stringbuilder
		b31686.append(" SafeStuff"); // append some safe content
		b31686.replace(b31686.length()-"Chars".length(),b31686.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31686 = new java.util.HashMap<String,Object>();
		map31686.put("key31686", b31686.toString()); // put in a collection
		String c31686 = (String)map31686.get("key31686"); // get it back out
		String d31686 = c31686.substring(0,c31686.length()-1); // extract most of it
		String e31686 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31686.getBytes() ) )); // B64 encode and decode it
		String f31686 = e31686.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31686 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31686); // reflection
	
		return bar;	
	}
}
