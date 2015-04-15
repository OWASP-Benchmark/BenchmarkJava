package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20150")
public class BenchmarkTest20150 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67488 = param; //assign
		StringBuilder b67488 = new StringBuilder(a67488);  // stick in stringbuilder
		b67488.append(" SafeStuff"); // append some safe content
		b67488.replace(b67488.length()-"Chars".length(),b67488.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67488 = new java.util.HashMap<String,Object>();
		map67488.put("key67488", b67488.toString()); // put in a collection
		String c67488 = (String)map67488.get("key67488"); // get it back out
		String d67488 = c67488.substring(0,c67488.length()-1); // extract most of it
		String e67488 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67488.getBytes() ) )); // B64 encode and decode it
		String f67488 = e67488.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g67488 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g67488); // reflection
	
		return bar;	
	}
}
