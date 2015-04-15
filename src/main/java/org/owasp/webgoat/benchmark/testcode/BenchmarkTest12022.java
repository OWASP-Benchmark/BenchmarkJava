package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12022")
public class BenchmarkTest12022 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

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
		String a76369 = param; //assign
		StringBuilder b76369 = new StringBuilder(a76369);  // stick in stringbuilder
		b76369.append(" SafeStuff"); // append some safe content
		b76369.replace(b76369.length()-"Chars".length(),b76369.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76369 = new java.util.HashMap<String,Object>();
		map76369.put("key76369", b76369.toString()); // put in a collection
		String c76369 = (String)map76369.get("key76369"); // get it back out
		String d76369 = c76369.substring(0,c76369.length()-1); // extract most of it
		String e76369 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76369.getBytes() ) )); // B64 encode and decode it
		String f76369 = e76369.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76369); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
