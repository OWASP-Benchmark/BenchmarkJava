package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08927")
public class BenchmarkTest08927 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a84816 = param; //assign
		StringBuilder b84816 = new StringBuilder(a84816);  // stick in stringbuilder
		b84816.append(" SafeStuff"); // append some safe content
		b84816.replace(b84816.length()-"Chars".length(),b84816.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84816 = new java.util.HashMap<String,Object>();
		map84816.put("key84816", b84816.toString()); // put in a collection
		String c84816 = (String)map84816.get("key84816"); // get it back out
		String d84816 = c84816.substring(0,c84816.length()-1); // extract most of it
		String e84816 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84816.getBytes() ) )); // B64 encode and decode it
		String f84816 = e84816.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84816 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84816); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
