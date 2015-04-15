package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07834")
public class BenchmarkTest07834 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71267 = param; //assign
		StringBuilder b71267 = new StringBuilder(a71267);  // stick in stringbuilder
		b71267.append(" SafeStuff"); // append some safe content
		b71267.replace(b71267.length()-"Chars".length(),b71267.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71267 = new java.util.HashMap<String,Object>();
		map71267.put("key71267", b71267.toString()); // put in a collection
		String c71267 = (String)map71267.get("key71267"); // get it back out
		String d71267 = c71267.substring(0,c71267.length()-1); // extract most of it
		String e71267 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71267.getBytes() ) )); // B64 encode and decode it
		String f71267 = e71267.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71267); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
