package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09401")
public class BenchmarkTest09401 extends HttpServlet {
	
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
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77777 = param; //assign
		StringBuilder b77777 = new StringBuilder(a77777);  // stick in stringbuilder
		b77777.append(" SafeStuff"); // append some safe content
		b77777.replace(b77777.length()-"Chars".length(),b77777.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77777 = new java.util.HashMap<String,Object>();
		map77777.put("key77777", b77777.toString()); // put in a collection
		String c77777 = (String)map77777.get("key77777"); // get it back out
		String d77777 = c77777.substring(0,c77777.length()-1); // extract most of it
		String e77777 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77777.getBytes() ) )); // B64 encode and decode it
		String f77777 = e77777.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77777); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
