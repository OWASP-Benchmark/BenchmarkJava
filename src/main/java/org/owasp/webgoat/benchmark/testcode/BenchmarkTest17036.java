package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17036")
public class BenchmarkTest17036 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8572 = param; //assign
		StringBuilder b8572 = new StringBuilder(a8572);  // stick in stringbuilder
		b8572.append(" SafeStuff"); // append some safe content
		b8572.replace(b8572.length()-"Chars".length(),b8572.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8572 = new java.util.HashMap<String,Object>();
		map8572.put("key8572", b8572.toString()); // put in a collection
		String c8572 = (String)map8572.get("key8572"); // get it back out
		String d8572 = c8572.substring(0,c8572.length()-1); // extract most of it
		String e8572 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8572.getBytes() ) )); // B64 encode and decode it
		String f8572 = e8572.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g8572 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g8572); // reflection
	
		return bar;	
	}
}
