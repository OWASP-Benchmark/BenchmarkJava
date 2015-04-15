package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08016")
public class BenchmarkTest08016 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21829 = param; //assign
		StringBuilder b21829 = new StringBuilder(a21829);  // stick in stringbuilder
		b21829.append(" SafeStuff"); // append some safe content
		b21829.replace(b21829.length()-"Chars".length(),b21829.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21829 = new java.util.HashMap<String,Object>();
		map21829.put("key21829", b21829.toString()); // put in a collection
		String c21829 = (String)map21829.get("key21829"); // get it back out
		String d21829 = c21829.substring(0,c21829.length()-1); // extract most of it
		String e21829 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21829.getBytes() ) )); // B64 encode and decode it
		String f21829 = e21829.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21829); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
