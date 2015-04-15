package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03556")
public class BenchmarkTest03556 extends HttpServlet {
	
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
		
		
		
		// Chain a bunch of propagators in sequence
		String a54152 = param; //assign
		StringBuilder b54152 = new StringBuilder(a54152);  // stick in stringbuilder
		b54152.append(" SafeStuff"); // append some safe content
		b54152.replace(b54152.length()-"Chars".length(),b54152.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54152 = new java.util.HashMap<String,Object>();
		map54152.put("key54152", b54152.toString()); // put in a collection
		String c54152 = (String)map54152.get("key54152"); // get it back out
		String d54152 = c54152.substring(0,c54152.length()-1); // extract most of it
		String e54152 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54152.getBytes() ) )); // B64 encode and decode it
		String f54152 = e54152.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g54152 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g54152); // reflection
		
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}
}
