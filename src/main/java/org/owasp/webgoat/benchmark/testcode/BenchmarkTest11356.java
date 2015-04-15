package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11356")
public class BenchmarkTest11356 extends HttpServlet {
	
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
		String a6891 = param; //assign
		StringBuilder b6891 = new StringBuilder(a6891);  // stick in stringbuilder
		b6891.append(" SafeStuff"); // append some safe content
		b6891.replace(b6891.length()-"Chars".length(),b6891.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6891 = new java.util.HashMap<String,Object>();
		map6891.put("key6891", b6891.toString()); // put in a collection
		String c6891 = (String)map6891.get("key6891"); // get it back out
		String d6891 = c6891.substring(0,c6891.length()-1); // extract most of it
		String e6891 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6891.getBytes() ) )); // B64 encode and decode it
		String f6891 = e6891.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g6891 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6891); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
