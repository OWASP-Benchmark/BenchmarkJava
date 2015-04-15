package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09484")
public class BenchmarkTest09484 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61323 = param; //assign
		StringBuilder b61323 = new StringBuilder(a61323);  // stick in stringbuilder
		b61323.append(" SafeStuff"); // append some safe content
		b61323.replace(b61323.length()-"Chars".length(),b61323.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61323 = new java.util.HashMap<String,Object>();
		map61323.put("key61323", b61323.toString()); // put in a collection
		String c61323 = (String)map61323.get("key61323"); // get it back out
		String d61323 = c61323.substring(0,c61323.length()-1); // extract most of it
		String e61323 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61323.getBytes() ) )); // B64 encode and decode it
		String f61323 = e61323.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61323 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61323); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
