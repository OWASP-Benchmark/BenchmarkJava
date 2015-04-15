package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12480")
public class BenchmarkTest12480 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91581 = param; //assign
		StringBuilder b91581 = new StringBuilder(a91581);  // stick in stringbuilder
		b91581.append(" SafeStuff"); // append some safe content
		b91581.replace(b91581.length()-"Chars".length(),b91581.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91581 = new java.util.HashMap<String,Object>();
		map91581.put("key91581", b91581.toString()); // put in a collection
		String c91581 = (String)map91581.get("key91581"); // get it back out
		String d91581 = c91581.substring(0,c91581.length()-1); // extract most of it
		String e91581 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91581.getBytes() ) )); // B64 encode and decode it
		String f91581 = e91581.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91581); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
