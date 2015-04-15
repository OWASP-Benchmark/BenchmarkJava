package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10114")
public class BenchmarkTest10114 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a61859 = param; //assign
		StringBuilder b61859 = new StringBuilder(a61859);  // stick in stringbuilder
		b61859.append(" SafeStuff"); // append some safe content
		b61859.replace(b61859.length()-"Chars".length(),b61859.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61859 = new java.util.HashMap<String,Object>();
		map61859.put("key61859", b61859.toString()); // put in a collection
		String c61859 = (String)map61859.get("key61859"); // get it back out
		String d61859 = c61859.substring(0,c61859.length()-1); // extract most of it
		String e61859 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61859.getBytes() ) )); // B64 encode and decode it
		String f61859 = e61859.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61859 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61859); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
