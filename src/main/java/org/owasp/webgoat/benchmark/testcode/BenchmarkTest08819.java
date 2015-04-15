package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08819")
public class BenchmarkTest08819 extends HttpServlet {
	
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
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14353 = param; //assign
		StringBuilder b14353 = new StringBuilder(a14353);  // stick in stringbuilder
		b14353.append(" SafeStuff"); // append some safe content
		b14353.replace(b14353.length()-"Chars".length(),b14353.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14353 = new java.util.HashMap<String,Object>();
		map14353.put("key14353", b14353.toString()); // put in a collection
		String c14353 = (String)map14353.get("key14353"); // get it back out
		String d14353 = c14353.substring(0,c14353.length()-1); // extract most of it
		String e14353 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14353.getBytes() ) )); // B64 encode and decode it
		String f14353 = e14353.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g14353 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14353); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
