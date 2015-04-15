package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09891")
public class BenchmarkTest09891 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89402 = param; //assign
		StringBuilder b89402 = new StringBuilder(a89402);  // stick in stringbuilder
		b89402.append(" SafeStuff"); // append some safe content
		b89402.replace(b89402.length()-"Chars".length(),b89402.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89402 = new java.util.HashMap<String,Object>();
		map89402.put("key89402", b89402.toString()); // put in a collection
		String c89402 = (String)map89402.get("key89402"); // get it back out
		String d89402 = c89402.substring(0,c89402.length()-1); // extract most of it
		String e89402 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89402.getBytes() ) )); // B64 encode and decode it
		String f89402 = e89402.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g89402 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89402); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
