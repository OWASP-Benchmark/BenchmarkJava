package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13635")
public class BenchmarkTest13635 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47276 = param; //assign
		StringBuilder b47276 = new StringBuilder(a47276);  // stick in stringbuilder
		b47276.append(" SafeStuff"); // append some safe content
		b47276.replace(b47276.length()-"Chars".length(),b47276.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47276 = new java.util.HashMap<String,Object>();
		map47276.put("key47276", b47276.toString()); // put in a collection
		String c47276 = (String)map47276.get("key47276"); // get it back out
		String d47276 = c47276.substring(0,c47276.length()-1); // extract most of it
		String e47276 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47276.getBytes() ) )); // B64 encode and decode it
		String f47276 = e47276.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g47276 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47276); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
