package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09123")
public class BenchmarkTest09123 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a39140 = param; //assign
		StringBuilder b39140 = new StringBuilder(a39140);  // stick in stringbuilder
		b39140.append(" SafeStuff"); // append some safe content
		b39140.replace(b39140.length()-"Chars".length(),b39140.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39140 = new java.util.HashMap<String,Object>();
		map39140.put("key39140", b39140.toString()); // put in a collection
		String c39140 = (String)map39140.get("key39140"); // get it back out
		String d39140 = c39140.substring(0,c39140.length()-1); // extract most of it
		String e39140 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39140.getBytes() ) )); // B64 encode and decode it
		String f39140 = e39140.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f39140); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
