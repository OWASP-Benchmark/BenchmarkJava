package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08531")
public class BenchmarkTest08531 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23394 = param; //assign
		StringBuilder b23394 = new StringBuilder(a23394);  // stick in stringbuilder
		b23394.append(" SafeStuff"); // append some safe content
		b23394.replace(b23394.length()-"Chars".length(),b23394.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23394 = new java.util.HashMap<String,Object>();
		map23394.put("key23394", b23394.toString()); // put in a collection
		String c23394 = (String)map23394.get("key23394"); // get it back out
		String d23394 = c23394.substring(0,c23394.length()-1); // extract most of it
		String e23394 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23394.getBytes() ) )); // B64 encode and decode it
		String f23394 = e23394.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23394 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23394); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
