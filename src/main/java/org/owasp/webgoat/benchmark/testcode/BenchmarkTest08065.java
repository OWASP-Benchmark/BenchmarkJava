package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08065")
public class BenchmarkTest08065 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a25587 = param; //assign
		StringBuilder b25587 = new StringBuilder(a25587);  // stick in stringbuilder
		b25587.append(" SafeStuff"); // append some safe content
		b25587.replace(b25587.length()-"Chars".length(),b25587.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25587 = new java.util.HashMap<String,Object>();
		map25587.put("key25587", b25587.toString()); // put in a collection
		String c25587 = (String)map25587.get("key25587"); // get it back out
		String d25587 = c25587.substring(0,c25587.length()-1); // extract most of it
		String e25587 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25587.getBytes() ) )); // B64 encode and decode it
		String f25587 = e25587.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g25587 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g25587); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
