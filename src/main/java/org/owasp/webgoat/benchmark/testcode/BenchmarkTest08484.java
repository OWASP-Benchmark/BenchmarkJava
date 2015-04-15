package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08484")
public class BenchmarkTest08484 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40531 = param; //assign
		StringBuilder b40531 = new StringBuilder(a40531);  // stick in stringbuilder
		b40531.append(" SafeStuff"); // append some safe content
		b40531.replace(b40531.length()-"Chars".length(),b40531.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40531 = new java.util.HashMap<String,Object>();
		map40531.put("key40531", b40531.toString()); // put in a collection
		String c40531 = (String)map40531.get("key40531"); // get it back out
		String d40531 = c40531.substring(0,c40531.length()-1); // extract most of it
		String e40531 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40531.getBytes() ) )); // B64 encode and decode it
		String f40531 = e40531.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40531); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
