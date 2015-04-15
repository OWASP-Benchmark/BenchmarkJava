package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17272")
public class BenchmarkTest17272 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46932 = param; //assign
		StringBuilder b46932 = new StringBuilder(a46932);  // stick in stringbuilder
		b46932.append(" SafeStuff"); // append some safe content
		b46932.replace(b46932.length()-"Chars".length(),b46932.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46932 = new java.util.HashMap<String,Object>();
		map46932.put("key46932", b46932.toString()); // put in a collection
		String c46932 = (String)map46932.get("key46932"); // get it back out
		String d46932 = c46932.substring(0,c46932.length()-1); // extract most of it
		String e46932 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46932.getBytes() ) )); // B64 encode and decode it
		String f46932 = e46932.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g46932 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g46932); // reflection
	
		return bar;	
	}
}
