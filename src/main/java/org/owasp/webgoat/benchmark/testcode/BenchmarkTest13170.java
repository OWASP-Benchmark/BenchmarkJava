package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13170")
public class BenchmarkTest13170 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11860 = param; //assign
		StringBuilder b11860 = new StringBuilder(a11860);  // stick in stringbuilder
		b11860.append(" SafeStuff"); // append some safe content
		b11860.replace(b11860.length()-"Chars".length(),b11860.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11860 = new java.util.HashMap<String,Object>();
		map11860.put("key11860", b11860.toString()); // put in a collection
		String c11860 = (String)map11860.get("key11860"); // get it back out
		String d11860 = c11860.substring(0,c11860.length()-1); // extract most of it
		String e11860 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11860.getBytes() ) )); // B64 encode and decode it
		String f11860 = e11860.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g11860 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11860); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
