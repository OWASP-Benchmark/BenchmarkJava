package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08274")
public class BenchmarkTest08274 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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
		String a38706 = param; //assign
		StringBuilder b38706 = new StringBuilder(a38706);  // stick in stringbuilder
		b38706.append(" SafeStuff"); // append some safe content
		b38706.replace(b38706.length()-"Chars".length(),b38706.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38706 = new java.util.HashMap<String,Object>();
		map38706.put("key38706", b38706.toString()); // put in a collection
		String c38706 = (String)map38706.get("key38706"); // get it back out
		String d38706 = c38706.substring(0,c38706.length()-1); // extract most of it
		String e38706 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38706.getBytes() ) )); // B64 encode and decode it
		String f38706 = e38706.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38706); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
