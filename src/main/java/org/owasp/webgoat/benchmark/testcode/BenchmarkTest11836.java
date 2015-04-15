package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11836")
public class BenchmarkTest11836 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98610 = param; //assign
		StringBuilder b98610 = new StringBuilder(a98610);  // stick in stringbuilder
		b98610.append(" SafeStuff"); // append some safe content
		b98610.replace(b98610.length()-"Chars".length(),b98610.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98610 = new java.util.HashMap<String,Object>();
		map98610.put("key98610", b98610.toString()); // put in a collection
		String c98610 = (String)map98610.get("key98610"); // get it back out
		String d98610 = c98610.substring(0,c98610.length()-1); // extract most of it
		String e98610 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98610.getBytes() ) )); // B64 encode and decode it
		String f98610 = e98610.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g98610 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g98610); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
