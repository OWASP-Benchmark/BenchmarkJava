package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17514")
public class BenchmarkTest17514 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26822 = param; //assign
		StringBuilder b26822 = new StringBuilder(a26822);  // stick in stringbuilder
		b26822.append(" SafeStuff"); // append some safe content
		b26822.replace(b26822.length()-"Chars".length(),b26822.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26822 = new java.util.HashMap<String,Object>();
		map26822.put("key26822", b26822.toString()); // put in a collection
		String c26822 = (String)map26822.get("key26822"); // get it back out
		String d26822 = c26822.substring(0,c26822.length()-1); // extract most of it
		String e26822 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26822.getBytes() ) )); // B64 encode and decode it
		String f26822 = e26822.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g26822 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26822); // reflection
	
		return bar;	
	}
}
