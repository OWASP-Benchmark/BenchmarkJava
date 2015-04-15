package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08034")
public class BenchmarkTest08034 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83286 = param; //assign
		StringBuilder b83286 = new StringBuilder(a83286);  // stick in stringbuilder
		b83286.append(" SafeStuff"); // append some safe content
		b83286.replace(b83286.length()-"Chars".length(),b83286.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83286 = new java.util.HashMap<String,Object>();
		map83286.put("key83286", b83286.toString()); // put in a collection
		String c83286 = (String)map83286.get("key83286"); // get it back out
		String d83286 = c83286.substring(0,c83286.length()-1); // extract most of it
		String e83286 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83286.getBytes() ) )); // B64 encode and decode it
		String f83286 = e83286.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83286); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
