package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17441")
public class BenchmarkTest17441 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a56039 = param; //assign
		StringBuilder b56039 = new StringBuilder(a56039);  // stick in stringbuilder
		b56039.append(" SafeStuff"); // append some safe content
		b56039.replace(b56039.length()-"Chars".length(),b56039.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56039 = new java.util.HashMap<String,Object>();
		map56039.put("key56039", b56039.toString()); // put in a collection
		String c56039 = (String)map56039.get("key56039"); // get it back out
		String d56039 = c56039.substring(0,c56039.length()-1); // extract most of it
		String e56039 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56039.getBytes() ) )); // B64 encode and decode it
		String f56039 = e56039.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g56039 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g56039); // reflection
	
		return bar;	
	}
}
