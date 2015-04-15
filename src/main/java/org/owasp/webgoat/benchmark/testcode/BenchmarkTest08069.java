package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08069")
public class BenchmarkTest08069 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a74562 = param; //assign
		StringBuilder b74562 = new StringBuilder(a74562);  // stick in stringbuilder
		b74562.append(" SafeStuff"); // append some safe content
		b74562.replace(b74562.length()-"Chars".length(),b74562.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map74562 = new java.util.HashMap<String,Object>();
		map74562.put("key74562", b74562.toString()); // put in a collection
		String c74562 = (String)map74562.get("key74562"); // get it back out
		String d74562 = c74562.substring(0,c74562.length()-1); // extract most of it
		String e74562 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d74562.getBytes() ) )); // B64 encode and decode it
		String f74562 = e74562.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f74562); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
