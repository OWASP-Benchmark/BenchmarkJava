package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17623")
public class BenchmarkTest17623 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34604 = param; //assign
		StringBuilder b34604 = new StringBuilder(a34604);  // stick in stringbuilder
		b34604.append(" SafeStuff"); // append some safe content
		b34604.replace(b34604.length()-"Chars".length(),b34604.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34604 = new java.util.HashMap<String,Object>();
		map34604.put("key34604", b34604.toString()); // put in a collection
		String c34604 = (String)map34604.get("key34604"); // get it back out
		String d34604 = c34604.substring(0,c34604.length()-1); // extract most of it
		String e34604 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34604.getBytes() ) )); // B64 encode and decode it
		String f34604 = e34604.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g34604 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34604); // reflection
	
		return bar;	
	}
}
