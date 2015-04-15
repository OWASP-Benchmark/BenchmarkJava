package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07941")
public class BenchmarkTest07941 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33383 = param; //assign
		StringBuilder b33383 = new StringBuilder(a33383);  // stick in stringbuilder
		b33383.append(" SafeStuff"); // append some safe content
		b33383.replace(b33383.length()-"Chars".length(),b33383.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33383 = new java.util.HashMap<String,Object>();
		map33383.put("key33383", b33383.toString()); // put in a collection
		String c33383 = (String)map33383.get("key33383"); // get it back out
		String d33383 = c33383.substring(0,c33383.length()-1); // extract most of it
		String e33383 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33383.getBytes() ) )); // B64 encode and decode it
		String f33383 = e33383.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g33383 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g33383); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
