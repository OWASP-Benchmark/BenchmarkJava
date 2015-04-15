package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14903")
public class BenchmarkTest14903 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71246 = param; //assign
		StringBuilder b71246 = new StringBuilder(a71246);  // stick in stringbuilder
		b71246.append(" SafeStuff"); // append some safe content
		b71246.replace(b71246.length()-"Chars".length(),b71246.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71246 = new java.util.HashMap<String,Object>();
		map71246.put("key71246", b71246.toString()); // put in a collection
		String c71246 = (String)map71246.get("key71246"); // get it back out
		String d71246 = c71246.substring(0,c71246.length()-1); // extract most of it
		String e71246 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71246.getBytes() ) )); // B64 encode and decode it
		String f71246 = e71246.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71246 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71246); // reflection
	
		return bar;	
	}
}
