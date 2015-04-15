package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09959")
public class BenchmarkTest09959 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6947 = param; //assign
		StringBuilder b6947 = new StringBuilder(a6947);  // stick in stringbuilder
		b6947.append(" SafeStuff"); // append some safe content
		b6947.replace(b6947.length()-"Chars".length(),b6947.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6947 = new java.util.HashMap<String,Object>();
		map6947.put("key6947", b6947.toString()); // put in a collection
		String c6947 = (String)map6947.get("key6947"); // get it back out
		String d6947 = c6947.substring(0,c6947.length()-1); // extract most of it
		String e6947 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6947.getBytes() ) )); // B64 encode and decode it
		String f6947 = e6947.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g6947 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6947); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
