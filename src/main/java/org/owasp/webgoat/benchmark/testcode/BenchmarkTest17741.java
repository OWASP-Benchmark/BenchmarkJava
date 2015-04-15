package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17741")
public class BenchmarkTest17741 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a39976 = param; //assign
		StringBuilder b39976 = new StringBuilder(a39976);  // stick in stringbuilder
		b39976.append(" SafeStuff"); // append some safe content
		b39976.replace(b39976.length()-"Chars".length(),b39976.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39976 = new java.util.HashMap<String,Object>();
		map39976.put("key39976", b39976.toString()); // put in a collection
		String c39976 = (String)map39976.get("key39976"); // get it back out
		String d39976 = c39976.substring(0,c39976.length()-1); // extract most of it
		String e39976 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39976.getBytes() ) )); // B64 encode and decode it
		String f39976 = e39976.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g39976 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g39976); // reflection
	
		return bar;	
	}
}
