package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09113")
public class BenchmarkTest09113 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a80767 = param; //assign
		StringBuilder b80767 = new StringBuilder(a80767);  // stick in stringbuilder
		b80767.append(" SafeStuff"); // append some safe content
		b80767.replace(b80767.length()-"Chars".length(),b80767.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80767 = new java.util.HashMap<String,Object>();
		map80767.put("key80767", b80767.toString()); // put in a collection
		String c80767 = (String)map80767.get("key80767"); // get it back out
		String d80767 = c80767.substring(0,c80767.length()-1); // extract most of it
		String e80767 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80767.getBytes() ) )); // B64 encode and decode it
		String f80767 = e80767.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f80767); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
