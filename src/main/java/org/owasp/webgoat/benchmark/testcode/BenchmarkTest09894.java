package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09894")
public class BenchmarkTest09894 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31644 = param; //assign
		StringBuilder b31644 = new StringBuilder(a31644);  // stick in stringbuilder
		b31644.append(" SafeStuff"); // append some safe content
		b31644.replace(b31644.length()-"Chars".length(),b31644.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31644 = new java.util.HashMap<String,Object>();
		map31644.put("key31644", b31644.toString()); // put in a collection
		String c31644 = (String)map31644.get("key31644"); // get it back out
		String d31644 = c31644.substring(0,c31644.length()-1); // extract most of it
		String e31644 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31644.getBytes() ) )); // B64 encode and decode it
		String f31644 = e31644.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31644); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
