package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08232")
public class BenchmarkTest08232 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88687 = param; //assign
		StringBuilder b88687 = new StringBuilder(a88687);  // stick in stringbuilder
		b88687.append(" SafeStuff"); // append some safe content
		b88687.replace(b88687.length()-"Chars".length(),b88687.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88687 = new java.util.HashMap<String,Object>();
		map88687.put("key88687", b88687.toString()); // put in a collection
		String c88687 = (String)map88687.get("key88687"); // get it back out
		String d88687 = c88687.substring(0,c88687.length()-1); // extract most of it
		String e88687 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88687.getBytes() ) )); // B64 encode and decode it
		String f88687 = e88687.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88687); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
