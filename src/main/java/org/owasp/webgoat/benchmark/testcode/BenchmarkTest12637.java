package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12637")
public class BenchmarkTest12637 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

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
		String a49432 = param; //assign
		StringBuilder b49432 = new StringBuilder(a49432);  // stick in stringbuilder
		b49432.append(" SafeStuff"); // append some safe content
		b49432.replace(b49432.length()-"Chars".length(),b49432.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49432 = new java.util.HashMap<String,Object>();
		map49432.put("key49432", b49432.toString()); // put in a collection
		String c49432 = (String)map49432.get("key49432"); // get it back out
		String d49432 = c49432.substring(0,c49432.length()-1); // extract most of it
		String e49432 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49432.getBytes() ) )); // B64 encode and decode it
		String f49432 = e49432.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f49432); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
