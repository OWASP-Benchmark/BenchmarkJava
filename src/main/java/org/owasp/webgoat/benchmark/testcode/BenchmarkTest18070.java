package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18070")
public class BenchmarkTest18070 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94377 = param; //assign
		StringBuilder b94377 = new StringBuilder(a94377);  // stick in stringbuilder
		b94377.append(" SafeStuff"); // append some safe content
		b94377.replace(b94377.length()-"Chars".length(),b94377.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94377 = new java.util.HashMap<String,Object>();
		map94377.put("key94377", b94377.toString()); // put in a collection
		String c94377 = (String)map94377.get("key94377"); // get it back out
		String d94377 = c94377.substring(0,c94377.length()-1); // extract most of it
		String e94377 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94377.getBytes() ) )); // B64 encode and decode it
		String f94377 = e94377.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g94377 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94377); // reflection
	
		return bar;	
	}
}
