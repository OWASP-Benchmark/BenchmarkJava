package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10119")
public class BenchmarkTest10119 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a88393 = param; //assign
		StringBuilder b88393 = new StringBuilder(a88393);  // stick in stringbuilder
		b88393.append(" SafeStuff"); // append some safe content
		b88393.replace(b88393.length()-"Chars".length(),b88393.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88393 = new java.util.HashMap<String,Object>();
		map88393.put("key88393", b88393.toString()); // put in a collection
		String c88393 = (String)map88393.get("key88393"); // get it back out
		String d88393 = c88393.substring(0,c88393.length()-1); // extract most of it
		String e88393 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88393.getBytes() ) )); // B64 encode and decode it
		String f88393 = e88393.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88393); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
