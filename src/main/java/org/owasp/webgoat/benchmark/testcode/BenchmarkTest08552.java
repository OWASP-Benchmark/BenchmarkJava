package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08552")
public class BenchmarkTest08552 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73867 = param; //assign
		StringBuilder b73867 = new StringBuilder(a73867);  // stick in stringbuilder
		b73867.append(" SafeStuff"); // append some safe content
		b73867.replace(b73867.length()-"Chars".length(),b73867.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73867 = new java.util.HashMap<String,Object>();
		map73867.put("key73867", b73867.toString()); // put in a collection
		String c73867 = (String)map73867.get("key73867"); // get it back out
		String d73867 = c73867.substring(0,c73867.length()-1); // extract most of it
		String e73867 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73867.getBytes() ) )); // B64 encode and decode it
		String f73867 = e73867.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73867 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73867); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
