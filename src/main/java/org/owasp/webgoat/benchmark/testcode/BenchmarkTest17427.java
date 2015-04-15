package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17427")
public class BenchmarkTest17427 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33369 = param; //assign
		StringBuilder b33369 = new StringBuilder(a33369);  // stick in stringbuilder
		b33369.append(" SafeStuff"); // append some safe content
		b33369.replace(b33369.length()-"Chars".length(),b33369.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33369 = new java.util.HashMap<String,Object>();
		map33369.put("key33369", b33369.toString()); // put in a collection
		String c33369 = (String)map33369.get("key33369"); // get it back out
		String d33369 = c33369.substring(0,c33369.length()-1); // extract most of it
		String e33369 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33369.getBytes() ) )); // B64 encode and decode it
		String f33369 = e33369.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g33369 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g33369); // reflection
	
		return bar;	
	}
}
