package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09107")
public class BenchmarkTest09107 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15554 = param; //assign
		StringBuilder b15554 = new StringBuilder(a15554);  // stick in stringbuilder
		b15554.append(" SafeStuff"); // append some safe content
		b15554.replace(b15554.length()-"Chars".length(),b15554.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15554 = new java.util.HashMap<String,Object>();
		map15554.put("key15554", b15554.toString()); // put in a collection
		String c15554 = (String)map15554.get("key15554"); // get it back out
		String d15554 = c15554.substring(0,c15554.length()-1); // extract most of it
		String e15554 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15554.getBytes() ) )); // B64 encode and decode it
		String f15554 = e15554.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15554); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
