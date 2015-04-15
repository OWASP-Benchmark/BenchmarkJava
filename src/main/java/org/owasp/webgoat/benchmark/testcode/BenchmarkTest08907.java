package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08907")
public class BenchmarkTest08907 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85857 = param; //assign
		StringBuilder b85857 = new StringBuilder(a85857);  // stick in stringbuilder
		b85857.append(" SafeStuff"); // append some safe content
		b85857.replace(b85857.length()-"Chars".length(),b85857.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85857 = new java.util.HashMap<String,Object>();
		map85857.put("key85857", b85857.toString()); // put in a collection
		String c85857 = (String)map85857.get("key85857"); // get it back out
		String d85857 = c85857.substring(0,c85857.length()-1); // extract most of it
		String e85857 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85857.getBytes() ) )); // B64 encode and decode it
		String f85857 = e85857.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85857); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
