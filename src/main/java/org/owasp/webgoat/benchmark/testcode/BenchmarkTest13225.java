package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13225")
public class BenchmarkTest13225 extends HttpServlet {
	
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
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71220 = param; //assign
		StringBuilder b71220 = new StringBuilder(a71220);  // stick in stringbuilder
		b71220.append(" SafeStuff"); // append some safe content
		b71220.replace(b71220.length()-"Chars".length(),b71220.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71220 = new java.util.HashMap<String,Object>();
		map71220.put("key71220", b71220.toString()); // put in a collection
		String c71220 = (String)map71220.get("key71220"); // get it back out
		String d71220 = c71220.substring(0,c71220.length()-1); // extract most of it
		String e71220 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71220.getBytes() ) )); // B64 encode and decode it
		String f71220 = e71220.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71220); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
