package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10161")
public class BenchmarkTest10161 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64478 = param; //assign
		StringBuilder b64478 = new StringBuilder(a64478);  // stick in stringbuilder
		b64478.append(" SafeStuff"); // append some safe content
		b64478.replace(b64478.length()-"Chars".length(),b64478.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64478 = new java.util.HashMap<String,Object>();
		map64478.put("key64478", b64478.toString()); // put in a collection
		String c64478 = (String)map64478.get("key64478"); // get it back out
		String d64478 = c64478.substring(0,c64478.length()-1); // extract most of it
		String e64478 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64478.getBytes() ) )); // B64 encode and decode it
		String f64478 = e64478.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64478); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
