package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12495")
public class BenchmarkTest12495 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

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
		String a34566 = param; //assign
		StringBuilder b34566 = new StringBuilder(a34566);  // stick in stringbuilder
		b34566.append(" SafeStuff"); // append some safe content
		b34566.replace(b34566.length()-"Chars".length(),b34566.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34566 = new java.util.HashMap<String,Object>();
		map34566.put("key34566", b34566.toString()); // put in a collection
		String c34566 = (String)map34566.get("key34566"); // get it back out
		String d34566 = c34566.substring(0,c34566.length()-1); // extract most of it
		String e34566 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34566.getBytes() ) )); // B64 encode and decode it
		String f34566 = e34566.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g34566 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34566); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
