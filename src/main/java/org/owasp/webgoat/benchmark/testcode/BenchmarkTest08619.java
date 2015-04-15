package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08619")
public class BenchmarkTest08619 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a48287 = param; //assign
		StringBuilder b48287 = new StringBuilder(a48287);  // stick in stringbuilder
		b48287.append(" SafeStuff"); // append some safe content
		b48287.replace(b48287.length()-"Chars".length(),b48287.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48287 = new java.util.HashMap<String,Object>();
		map48287.put("key48287", b48287.toString()); // put in a collection
		String c48287 = (String)map48287.get("key48287"); // get it back out
		String d48287 = c48287.substring(0,c48287.length()-1); // extract most of it
		String e48287 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48287.getBytes() ) )); // B64 encode and decode it
		String f48287 = e48287.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g48287 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g48287); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
