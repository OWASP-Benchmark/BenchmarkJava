package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08924")
public class BenchmarkTest08924 extends HttpServlet {
	
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
		String a58086 = param; //assign
		StringBuilder b58086 = new StringBuilder(a58086);  // stick in stringbuilder
		b58086.append(" SafeStuff"); // append some safe content
		b58086.replace(b58086.length()-"Chars".length(),b58086.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58086 = new java.util.HashMap<String,Object>();
		map58086.put("key58086", b58086.toString()); // put in a collection
		String c58086 = (String)map58086.get("key58086"); // get it back out
		String d58086 = c58086.substring(0,c58086.length()-1); // extract most of it
		String e58086 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58086.getBytes() ) )); // B64 encode and decode it
		String f58086 = e58086.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58086); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
