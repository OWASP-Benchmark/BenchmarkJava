package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11271")
public class BenchmarkTest11271 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72986 = param; //assign
		StringBuilder b72986 = new StringBuilder(a72986);  // stick in stringbuilder
		b72986.append(" SafeStuff"); // append some safe content
		b72986.replace(b72986.length()-"Chars".length(),b72986.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72986 = new java.util.HashMap<String,Object>();
		map72986.put("key72986", b72986.toString()); // put in a collection
		String c72986 = (String)map72986.get("key72986"); // get it back out
		String d72986 = c72986.substring(0,c72986.length()-1); // extract most of it
		String e72986 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72986.getBytes() ) )); // B64 encode and decode it
		String f72986 = e72986.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g72986 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72986); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
