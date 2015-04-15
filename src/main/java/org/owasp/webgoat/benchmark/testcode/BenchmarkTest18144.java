package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18144")
public class BenchmarkTest18144 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36865 = param; //assign
		StringBuilder b36865 = new StringBuilder(a36865);  // stick in stringbuilder
		b36865.append(" SafeStuff"); // append some safe content
		b36865.replace(b36865.length()-"Chars".length(),b36865.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36865 = new java.util.HashMap<String,Object>();
		map36865.put("key36865", b36865.toString()); // put in a collection
		String c36865 = (String)map36865.get("key36865"); // get it back out
		String d36865 = c36865.substring(0,c36865.length()-1); // extract most of it
		String e36865 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36865.getBytes() ) )); // B64 encode and decode it
		String f36865 = e36865.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g36865 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g36865); // reflection
	
		return bar;	
	}
}
