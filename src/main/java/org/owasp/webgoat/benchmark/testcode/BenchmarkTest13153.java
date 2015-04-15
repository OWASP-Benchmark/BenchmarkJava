package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13153")
public class BenchmarkTest13153 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86325 = param; //assign
		StringBuilder b86325 = new StringBuilder(a86325);  // stick in stringbuilder
		b86325.append(" SafeStuff"); // append some safe content
		b86325.replace(b86325.length()-"Chars".length(),b86325.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86325 = new java.util.HashMap<String,Object>();
		map86325.put("key86325", b86325.toString()); // put in a collection
		String c86325 = (String)map86325.get("key86325"); // get it back out
		String d86325 = c86325.substring(0,c86325.length()-1); // extract most of it
		String e86325 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86325.getBytes() ) )); // B64 encode and decode it
		String f86325 = e86325.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86325 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86325); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
