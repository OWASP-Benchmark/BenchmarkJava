package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07919")
public class BenchmarkTest07919 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a534 = param; //assign
		StringBuilder b534 = new StringBuilder(a534);  // stick in stringbuilder
		b534.append(" SafeStuff"); // append some safe content
		b534.replace(b534.length()-"Chars".length(),b534.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map534 = new java.util.HashMap<String,Object>();
		map534.put("key534", b534.toString()); // put in a collection
		String c534 = (String)map534.get("key534"); // get it back out
		String d534 = c534.substring(0,c534.length()-1); // extract most of it
		String e534 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d534.getBytes() ) )); // B64 encode and decode it
		String f534 = e534.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f534); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
