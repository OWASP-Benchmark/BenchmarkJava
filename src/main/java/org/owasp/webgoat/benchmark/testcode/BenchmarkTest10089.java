package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10089")
public class BenchmarkTest10089 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32990 = param; //assign
		StringBuilder b32990 = new StringBuilder(a32990);  // stick in stringbuilder
		b32990.append(" SafeStuff"); // append some safe content
		b32990.replace(b32990.length()-"Chars".length(),b32990.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32990 = new java.util.HashMap<String,Object>();
		map32990.put("key32990", b32990.toString()); // put in a collection
		String c32990 = (String)map32990.get("key32990"); // get it back out
		String d32990 = c32990.substring(0,c32990.length()-1); // extract most of it
		String e32990 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32990.getBytes() ) )); // B64 encode and decode it
		String f32990 = e32990.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g32990 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g32990); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
