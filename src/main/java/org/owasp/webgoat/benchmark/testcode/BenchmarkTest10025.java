package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10025")
public class BenchmarkTest10025 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51649 = param; //assign
		StringBuilder b51649 = new StringBuilder(a51649);  // stick in stringbuilder
		b51649.append(" SafeStuff"); // append some safe content
		b51649.replace(b51649.length()-"Chars".length(),b51649.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51649 = new java.util.HashMap<String,Object>();
		map51649.put("key51649", b51649.toString()); // put in a collection
		String c51649 = (String)map51649.get("key51649"); // get it back out
		String d51649 = c51649.substring(0,c51649.length()-1); // extract most of it
		String e51649 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51649.getBytes() ) )); // B64 encode and decode it
		String f51649 = e51649.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51649 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51649); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
