package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08226")
public class BenchmarkTest08226 extends HttpServlet {
	
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
		String a66779 = param; //assign
		StringBuilder b66779 = new StringBuilder(a66779);  // stick in stringbuilder
		b66779.append(" SafeStuff"); // append some safe content
		b66779.replace(b66779.length()-"Chars".length(),b66779.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66779 = new java.util.HashMap<String,Object>();
		map66779.put("key66779", b66779.toString()); // put in a collection
		String c66779 = (String)map66779.get("key66779"); // get it back out
		String d66779 = c66779.substring(0,c66779.length()-1); // extract most of it
		String e66779 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66779.getBytes() ) )); // B64 encode and decode it
		String f66779 = e66779.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g66779 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g66779); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
