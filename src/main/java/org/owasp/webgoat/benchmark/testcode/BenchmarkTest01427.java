package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01427")
public class BenchmarkTest01427 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a63581 = param; //assign
		StringBuilder b63581 = new StringBuilder(a63581);  // stick in stringbuilder
		b63581.append(" SafeStuff"); // append some safe content
		b63581.replace(b63581.length()-"Chars".length(),b63581.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63581 = new java.util.HashMap<String,Object>();
		map63581.put("key63581", b63581.toString()); // put in a collection
		String c63581 = (String)map63581.get("key63581"); // get it back out
		String d63581 = c63581.substring(0,c63581.length()-1); // extract most of it
		String e63581 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63581.getBytes() ) )); // B64 encode and decode it
		String f63581 = e63581.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63581); // reflection
		
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}
