package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12544")
public class BenchmarkTest12544 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32609 = param; //assign
		StringBuilder b32609 = new StringBuilder(a32609);  // stick in stringbuilder
		b32609.append(" SafeStuff"); // append some safe content
		b32609.replace(b32609.length()-"Chars".length(),b32609.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32609 = new java.util.HashMap<String,Object>();
		map32609.put("key32609", b32609.toString()); // put in a collection
		String c32609 = (String)map32609.get("key32609"); // get it back out
		String d32609 = c32609.substring(0,c32609.length()-1); // extract most of it
		String e32609 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32609.getBytes() ) )); // B64 encode and decode it
		String f32609 = e32609.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32609); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
