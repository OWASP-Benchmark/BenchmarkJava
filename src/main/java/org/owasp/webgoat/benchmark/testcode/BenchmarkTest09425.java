package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09425")
public class BenchmarkTest09425 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92535 = param; //assign
		StringBuilder b92535 = new StringBuilder(a92535);  // stick in stringbuilder
		b92535.append(" SafeStuff"); // append some safe content
		b92535.replace(b92535.length()-"Chars".length(),b92535.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92535 = new java.util.HashMap<String,Object>();
		map92535.put("key92535", b92535.toString()); // put in a collection
		String c92535 = (String)map92535.get("key92535"); // get it back out
		String d92535 = c92535.substring(0,c92535.length()-1); // extract most of it
		String e92535 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92535.getBytes() ) )); // B64 encode and decode it
		String f92535 = e92535.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f92535); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
