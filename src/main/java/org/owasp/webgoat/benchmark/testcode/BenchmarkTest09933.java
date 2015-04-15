package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09933")
public class BenchmarkTest09933 extends HttpServlet {
	
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
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28609 = param; //assign
		StringBuilder b28609 = new StringBuilder(a28609);  // stick in stringbuilder
		b28609.append(" SafeStuff"); // append some safe content
		b28609.replace(b28609.length()-"Chars".length(),b28609.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28609 = new java.util.HashMap<String,Object>();
		map28609.put("key28609", b28609.toString()); // put in a collection
		String c28609 = (String)map28609.get("key28609"); // get it back out
		String d28609 = c28609.substring(0,c28609.length()-1); // extract most of it
		String e28609 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28609.getBytes() ) )); // B64 encode and decode it
		String f28609 = e28609.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f28609); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
