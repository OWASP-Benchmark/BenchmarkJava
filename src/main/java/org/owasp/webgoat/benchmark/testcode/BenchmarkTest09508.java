package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09508")
public class BenchmarkTest09508 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

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
		String a51349 = param; //assign
		StringBuilder b51349 = new StringBuilder(a51349);  // stick in stringbuilder
		b51349.append(" SafeStuff"); // append some safe content
		b51349.replace(b51349.length()-"Chars".length(),b51349.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51349 = new java.util.HashMap<String,Object>();
		map51349.put("key51349", b51349.toString()); // put in a collection
		String c51349 = (String)map51349.get("key51349"); // get it back out
		String d51349 = c51349.substring(0,c51349.length()-1); // extract most of it
		String e51349 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51349.getBytes() ) )); // B64 encode and decode it
		String f51349 = e51349.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51349); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
