package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13068")
public class BenchmarkTest13068 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64191 = param; //assign
		StringBuilder b64191 = new StringBuilder(a64191);  // stick in stringbuilder
		b64191.append(" SafeStuff"); // append some safe content
		b64191.replace(b64191.length()-"Chars".length(),b64191.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64191 = new java.util.HashMap<String,Object>();
		map64191.put("key64191", b64191.toString()); // put in a collection
		String c64191 = (String)map64191.get("key64191"); // get it back out
		String d64191 = c64191.substring(0,c64191.length()-1); // extract most of it
		String e64191 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64191.getBytes() ) )); // B64 encode and decode it
		String f64191 = e64191.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64191 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64191); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
