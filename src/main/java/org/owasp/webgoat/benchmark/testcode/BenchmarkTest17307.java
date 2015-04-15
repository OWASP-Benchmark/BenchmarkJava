package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17307")
public class BenchmarkTest17307 extends HttpServlet {
	
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
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a16926 = param; //assign
		StringBuilder b16926 = new StringBuilder(a16926);  // stick in stringbuilder
		b16926.append(" SafeStuff"); // append some safe content
		b16926.replace(b16926.length()-"Chars".length(),b16926.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16926 = new java.util.HashMap<String,Object>();
		map16926.put("key16926", b16926.toString()); // put in a collection
		String c16926 = (String)map16926.get("key16926"); // get it back out
		String d16926 = c16926.substring(0,c16926.length()-1); // extract most of it
		String e16926 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16926.getBytes() ) )); // B64 encode and decode it
		String f16926 = e16926.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g16926 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g16926); // reflection
	
		return bar;	
	}
}
