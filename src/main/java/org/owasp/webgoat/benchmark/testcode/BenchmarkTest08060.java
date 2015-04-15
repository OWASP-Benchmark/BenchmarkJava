package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08060")
public class BenchmarkTest08060 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55631 = param; //assign
		StringBuilder b55631 = new StringBuilder(a55631);  // stick in stringbuilder
		b55631.append(" SafeStuff"); // append some safe content
		b55631.replace(b55631.length()-"Chars".length(),b55631.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55631 = new java.util.HashMap<String,Object>();
		map55631.put("key55631", b55631.toString()); // put in a collection
		String c55631 = (String)map55631.get("key55631"); // get it back out
		String d55631 = c55631.substring(0,c55631.length()-1); // extract most of it
		String e55631 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55631.getBytes() ) )); // B64 encode and decode it
		String f55631 = e55631.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55631 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55631); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
