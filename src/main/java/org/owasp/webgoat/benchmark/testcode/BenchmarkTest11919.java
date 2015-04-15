package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11919")
public class BenchmarkTest11919 extends HttpServlet {
	
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
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6856 = param; //assign
		StringBuilder b6856 = new StringBuilder(a6856);  // stick in stringbuilder
		b6856.append(" SafeStuff"); // append some safe content
		b6856.replace(b6856.length()-"Chars".length(),b6856.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6856 = new java.util.HashMap<String,Object>();
		map6856.put("key6856", b6856.toString()); // put in a collection
		String c6856 = (String)map6856.get("key6856"); // get it back out
		String d6856 = c6856.substring(0,c6856.length()-1); // extract most of it
		String e6856 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6856.getBytes() ) )); // B64 encode and decode it
		String f6856 = e6856.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6856); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
