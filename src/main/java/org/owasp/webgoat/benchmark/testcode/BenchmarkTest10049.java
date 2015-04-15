package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10049")
public class BenchmarkTest10049 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a16126 = param; //assign
		StringBuilder b16126 = new StringBuilder(a16126);  // stick in stringbuilder
		b16126.append(" SafeStuff"); // append some safe content
		b16126.replace(b16126.length()-"Chars".length(),b16126.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16126 = new java.util.HashMap<String,Object>();
		map16126.put("key16126", b16126.toString()); // put in a collection
		String c16126 = (String)map16126.get("key16126"); // get it back out
		String d16126 = c16126.substring(0,c16126.length()-1); // extract most of it
		String e16126 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16126.getBytes() ) )); // B64 encode and decode it
		String f16126 = e16126.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g16126 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g16126); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
