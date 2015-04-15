package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17410")
public class BenchmarkTest17410 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61820 = param; //assign
		StringBuilder b61820 = new StringBuilder(a61820);  // stick in stringbuilder
		b61820.append(" SafeStuff"); // append some safe content
		b61820.replace(b61820.length()-"Chars".length(),b61820.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61820 = new java.util.HashMap<String,Object>();
		map61820.put("key61820", b61820.toString()); // put in a collection
		String c61820 = (String)map61820.get("key61820"); // get it back out
		String d61820 = c61820.substring(0,c61820.length()-1); // extract most of it
		String e61820 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61820.getBytes() ) )); // B64 encode and decode it
		String f61820 = e61820.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61820 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61820); // reflection
	
		return bar;	
	}
}
