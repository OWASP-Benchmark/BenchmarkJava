package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17599")
public class BenchmarkTest17599 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29544 = param; //assign
		StringBuilder b29544 = new StringBuilder(a29544);  // stick in stringbuilder
		b29544.append(" SafeStuff"); // append some safe content
		b29544.replace(b29544.length()-"Chars".length(),b29544.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29544 = new java.util.HashMap<String,Object>();
		map29544.put("key29544", b29544.toString()); // put in a collection
		String c29544 = (String)map29544.get("key29544"); // get it back out
		String d29544 = c29544.substring(0,c29544.length()-1); // extract most of it
		String e29544 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29544.getBytes() ) )); // B64 encode and decode it
		String f29544 = e29544.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g29544 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g29544); // reflection
	
		return bar;	
	}
}
