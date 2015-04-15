package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10023")
public class BenchmarkTest10023 extends HttpServlet {
	
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
		String a54023 = param; //assign
		StringBuilder b54023 = new StringBuilder(a54023);  // stick in stringbuilder
		b54023.append(" SafeStuff"); // append some safe content
		b54023.replace(b54023.length()-"Chars".length(),b54023.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54023 = new java.util.HashMap<String,Object>();
		map54023.put("key54023", b54023.toString()); // put in a collection
		String c54023 = (String)map54023.get("key54023"); // get it back out
		String d54023 = c54023.substring(0,c54023.length()-1); // extract most of it
		String e54023 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54023.getBytes() ) )); // B64 encode and decode it
		String f54023 = e54023.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54023); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
