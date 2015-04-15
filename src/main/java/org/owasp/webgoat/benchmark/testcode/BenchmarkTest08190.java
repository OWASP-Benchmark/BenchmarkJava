package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08190")
public class BenchmarkTest08190 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21033 = param; //assign
		StringBuilder b21033 = new StringBuilder(a21033);  // stick in stringbuilder
		b21033.append(" SafeStuff"); // append some safe content
		b21033.replace(b21033.length()-"Chars".length(),b21033.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21033 = new java.util.HashMap<String,Object>();
		map21033.put("key21033", b21033.toString()); // put in a collection
		String c21033 = (String)map21033.get("key21033"); // get it back out
		String d21033 = c21033.substring(0,c21033.length()-1); // extract most of it
		String e21033 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21033.getBytes() ) )); // B64 encode and decode it
		String f21033 = e21033.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21033); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
