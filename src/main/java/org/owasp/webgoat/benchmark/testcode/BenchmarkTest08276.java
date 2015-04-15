package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08276")
public class BenchmarkTest08276 extends HttpServlet {
	
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
		String a35999 = param; //assign
		StringBuilder b35999 = new StringBuilder(a35999);  // stick in stringbuilder
		b35999.append(" SafeStuff"); // append some safe content
		b35999.replace(b35999.length()-"Chars".length(),b35999.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35999 = new java.util.HashMap<String,Object>();
		map35999.put("key35999", b35999.toString()); // put in a collection
		String c35999 = (String)map35999.get("key35999"); // get it back out
		String d35999 = c35999.substring(0,c35999.length()-1); // extract most of it
		String e35999 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35999.getBytes() ) )); // B64 encode and decode it
		String f35999 = e35999.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35999 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35999); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
