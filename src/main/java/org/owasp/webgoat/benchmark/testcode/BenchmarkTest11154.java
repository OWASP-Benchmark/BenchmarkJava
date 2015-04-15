package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11154")
public class BenchmarkTest11154 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a48534 = param; //assign
		StringBuilder b48534 = new StringBuilder(a48534);  // stick in stringbuilder
		b48534.append(" SafeStuff"); // append some safe content
		b48534.replace(b48534.length()-"Chars".length(),b48534.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48534 = new java.util.HashMap<String,Object>();
		map48534.put("key48534", b48534.toString()); // put in a collection
		String c48534 = (String)map48534.get("key48534"); // get it back out
		String d48534 = c48534.substring(0,c48534.length()-1); // extract most of it
		String e48534 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48534.getBytes() ) )); // B64 encode and decode it
		String f48534 = e48534.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48534); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
