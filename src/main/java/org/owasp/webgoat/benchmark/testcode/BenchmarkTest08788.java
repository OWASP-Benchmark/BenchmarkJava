package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08788")
public class BenchmarkTest08788 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36749 = param; //assign
		StringBuilder b36749 = new StringBuilder(a36749);  // stick in stringbuilder
		b36749.append(" SafeStuff"); // append some safe content
		b36749.replace(b36749.length()-"Chars".length(),b36749.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36749 = new java.util.HashMap<String,Object>();
		map36749.put("key36749", b36749.toString()); // put in a collection
		String c36749 = (String)map36749.get("key36749"); // get it back out
		String d36749 = c36749.substring(0,c36749.length()-1); // extract most of it
		String e36749 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36749.getBytes() ) )); // B64 encode and decode it
		String f36749 = e36749.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g36749 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g36749); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
