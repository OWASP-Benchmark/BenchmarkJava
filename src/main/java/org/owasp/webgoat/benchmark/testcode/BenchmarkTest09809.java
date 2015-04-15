package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09809")
public class BenchmarkTest09809 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38346 = param; //assign
		StringBuilder b38346 = new StringBuilder(a38346);  // stick in stringbuilder
		b38346.append(" SafeStuff"); // append some safe content
		b38346.replace(b38346.length()-"Chars".length(),b38346.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38346 = new java.util.HashMap<String,Object>();
		map38346.put("key38346", b38346.toString()); // put in a collection
		String c38346 = (String)map38346.get("key38346"); // get it back out
		String d38346 = c38346.substring(0,c38346.length()-1); // extract most of it
		String e38346 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38346.getBytes() ) )); // B64 encode and decode it
		String f38346 = e38346.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38346); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
