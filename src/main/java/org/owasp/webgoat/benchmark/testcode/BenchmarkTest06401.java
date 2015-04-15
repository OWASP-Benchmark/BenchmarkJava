package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06401")
public class BenchmarkTest06401 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a79764 = param; //assign
		StringBuilder b79764 = new StringBuilder(a79764);  // stick in stringbuilder
		b79764.append(" SafeStuff"); // append some safe content
		b79764.replace(b79764.length()-"Chars".length(),b79764.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79764 = new java.util.HashMap<String,Object>();
		map79764.put("key79764", b79764.toString()); // put in a collection
		String c79764 = (String)map79764.get("key79764"); // get it back out
		String d79764 = c79764.substring(0,c79764.length()-1); // extract most of it
		String e79764 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79764.getBytes() ) )); // B64 encode and decode it
		String f79764 = e79764.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g79764 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g79764); // reflection
		
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}
