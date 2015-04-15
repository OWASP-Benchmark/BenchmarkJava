package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14290")
public class BenchmarkTest14290 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34344 = param; //assign
		StringBuilder b34344 = new StringBuilder(a34344);  // stick in stringbuilder
		b34344.append(" SafeStuff"); // append some safe content
		b34344.replace(b34344.length()-"Chars".length(),b34344.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34344 = new java.util.HashMap<String,Object>();
		map34344.put("key34344", b34344.toString()); // put in a collection
		String c34344 = (String)map34344.get("key34344"); // get it back out
		String d34344 = c34344.substring(0,c34344.length()-1); // extract most of it
		String e34344 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34344.getBytes() ) )); // B64 encode and decode it
		String f34344 = e34344.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34344); // reflection
	
		return bar;	
	}
}
