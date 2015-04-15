package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09347")
public class BenchmarkTest09347 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9294 = param; //assign
		StringBuilder b9294 = new StringBuilder(a9294);  // stick in stringbuilder
		b9294.append(" SafeStuff"); // append some safe content
		b9294.replace(b9294.length()-"Chars".length(),b9294.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9294 = new java.util.HashMap<String,Object>();
		map9294.put("key9294", b9294.toString()); // put in a collection
		String c9294 = (String)map9294.get("key9294"); // get it back out
		String d9294 = c9294.substring(0,c9294.length()-1); // extract most of it
		String e9294 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9294.getBytes() ) )); // B64 encode and decode it
		String f9294 = e9294.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9294); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
