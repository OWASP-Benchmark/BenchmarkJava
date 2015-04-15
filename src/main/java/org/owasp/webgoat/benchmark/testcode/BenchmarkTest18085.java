package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18085")
public class BenchmarkTest18085 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a22871 = param; //assign
		StringBuilder b22871 = new StringBuilder(a22871);  // stick in stringbuilder
		b22871.append(" SafeStuff"); // append some safe content
		b22871.replace(b22871.length()-"Chars".length(),b22871.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22871 = new java.util.HashMap<String,Object>();
		map22871.put("key22871", b22871.toString()); // put in a collection
		String c22871 = (String)map22871.get("key22871"); // get it back out
		String d22871 = c22871.substring(0,c22871.length()-1); // extract most of it
		String e22871 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22871.getBytes() ) )); // B64 encode and decode it
		String f22871 = e22871.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g22871 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g22871); // reflection
	
		return bar;	
	}
}
