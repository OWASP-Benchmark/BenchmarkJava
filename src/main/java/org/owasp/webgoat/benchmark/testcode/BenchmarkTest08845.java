package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08845")
public class BenchmarkTest08845 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
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

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a80402 = param; //assign
		StringBuilder b80402 = new StringBuilder(a80402);  // stick in stringbuilder
		b80402.append(" SafeStuff"); // append some safe content
		b80402.replace(b80402.length()-"Chars".length(),b80402.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80402 = new java.util.HashMap<String,Object>();
		map80402.put("key80402", b80402.toString()); // put in a collection
		String c80402 = (String)map80402.get("key80402"); // get it back out
		String d80402 = c80402.substring(0,c80402.length()-1); // extract most of it
		String e80402 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80402.getBytes() ) )); // B64 encode and decode it
		String f80402 = e80402.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f80402); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
