package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13237")
public class BenchmarkTest13237 extends HttpServlet {
	
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
		String a61393 = param; //assign
		StringBuilder b61393 = new StringBuilder(a61393);  // stick in stringbuilder
		b61393.append(" SafeStuff"); // append some safe content
		b61393.replace(b61393.length()-"Chars".length(),b61393.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61393 = new java.util.HashMap<String,Object>();
		map61393.put("key61393", b61393.toString()); // put in a collection
		String c61393 = (String)map61393.get("key61393"); // get it back out
		String d61393 = c61393.substring(0,c61393.length()-1); // extract most of it
		String e61393 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61393.getBytes() ) )); // B64 encode and decode it
		String f61393 = e61393.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f61393); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
