package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03308")
public class BenchmarkTest03308 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a38146 = param; //assign
		StringBuilder b38146 = new StringBuilder(a38146);  // stick in stringbuilder
		b38146.append(" SafeStuff"); // append some safe content
		b38146.replace(b38146.length()-"Chars".length(),b38146.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38146 = new java.util.HashMap<String,Object>();
		map38146.put("key38146", b38146.toString()); // put in a collection
		String c38146 = (String)map38146.get("key38146"); // get it back out
		String d38146 = c38146.substring(0,c38146.length()-1); // extract most of it
		String e38146 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38146.getBytes() ) )); // B64 encode and decode it
		String f38146 = e38146.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38146); // reflection
		
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}
