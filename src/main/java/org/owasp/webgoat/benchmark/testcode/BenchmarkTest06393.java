package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06393")
public class BenchmarkTest06393 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a99961 = param; //assign
		StringBuilder b99961 = new StringBuilder(a99961);  // stick in stringbuilder
		b99961.append(" SafeStuff"); // append some safe content
		b99961.replace(b99961.length()-"Chars".length(),b99961.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99961 = new java.util.HashMap<String,Object>();
		map99961.put("key99961", b99961.toString()); // put in a collection
		String c99961 = (String)map99961.get("key99961"); // get it back out
		String d99961 = c99961.substring(0,c99961.length()-1); // extract most of it
		String e99961 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99961.getBytes() ) )); // B64 encode and decode it
		String f99961 = e99961.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f99961); // reflection
		
		
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
