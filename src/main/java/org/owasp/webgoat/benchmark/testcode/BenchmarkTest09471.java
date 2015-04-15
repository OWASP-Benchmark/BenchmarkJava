package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09471")
public class BenchmarkTest09471 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52006 = param; //assign
		StringBuilder b52006 = new StringBuilder(a52006);  // stick in stringbuilder
		b52006.append(" SafeStuff"); // append some safe content
		b52006.replace(b52006.length()-"Chars".length(),b52006.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52006 = new java.util.HashMap<String,Object>();
		map52006.put("key52006", b52006.toString()); // put in a collection
		String c52006 = (String)map52006.get("key52006"); // get it back out
		String d52006 = c52006.substring(0,c52006.length()-1); // extract most of it
		String e52006 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52006.getBytes() ) )); // B64 encode and decode it
		String f52006 = e52006.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f52006); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
