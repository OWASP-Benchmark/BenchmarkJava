package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09284")
public class BenchmarkTest09284 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83469 = param; //assign
		StringBuilder b83469 = new StringBuilder(a83469);  // stick in stringbuilder
		b83469.append(" SafeStuff"); // append some safe content
		b83469.replace(b83469.length()-"Chars".length(),b83469.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83469 = new java.util.HashMap<String,Object>();
		map83469.put("key83469", b83469.toString()); // put in a collection
		String c83469 = (String)map83469.get("key83469"); // get it back out
		String d83469 = c83469.substring(0,c83469.length()-1); // extract most of it
		String e83469 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83469.getBytes() ) )); // B64 encode and decode it
		String f83469 = e83469.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83469); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
