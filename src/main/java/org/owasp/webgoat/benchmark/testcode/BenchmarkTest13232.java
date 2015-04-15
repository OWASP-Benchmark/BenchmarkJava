package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13232")
public class BenchmarkTest13232 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a55259 = param; //assign
		StringBuilder b55259 = new StringBuilder(a55259);  // stick in stringbuilder
		b55259.append(" SafeStuff"); // append some safe content
		b55259.replace(b55259.length()-"Chars".length(),b55259.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55259 = new java.util.HashMap<String,Object>();
		map55259.put("key55259", b55259.toString()); // put in a collection
		String c55259 = (String)map55259.get("key55259"); // get it back out
		String d55259 = c55259.substring(0,c55259.length()-1); // extract most of it
		String e55259 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55259.getBytes() ) )); // B64 encode and decode it
		String f55259 = e55259.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55259 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55259); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
