package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11400")
public class BenchmarkTest11400 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
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
		String a45322 = param; //assign
		StringBuilder b45322 = new StringBuilder(a45322);  // stick in stringbuilder
		b45322.append(" SafeStuff"); // append some safe content
		b45322.replace(b45322.length()-"Chars".length(),b45322.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45322 = new java.util.HashMap<String,Object>();
		map45322.put("key45322", b45322.toString()); // put in a collection
		String c45322 = (String)map45322.get("key45322"); // get it back out
		String d45322 = c45322.substring(0,c45322.length()-1); // extract most of it
		String e45322 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45322.getBytes() ) )); // B64 encode and decode it
		String f45322 = e45322.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45322); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
