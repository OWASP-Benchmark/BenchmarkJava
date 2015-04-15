package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09162")
public class BenchmarkTest09162 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64639 = param; //assign
		StringBuilder b64639 = new StringBuilder(a64639);  // stick in stringbuilder
		b64639.append(" SafeStuff"); // append some safe content
		b64639.replace(b64639.length()-"Chars".length(),b64639.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64639 = new java.util.HashMap<String,Object>();
		map64639.put("key64639", b64639.toString()); // put in a collection
		String c64639 = (String)map64639.get("key64639"); // get it back out
		String d64639 = c64639.substring(0,c64639.length()-1); // extract most of it
		String e64639 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64639.getBytes() ) )); // B64 encode and decode it
		String f64639 = e64639.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64639 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64639); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
