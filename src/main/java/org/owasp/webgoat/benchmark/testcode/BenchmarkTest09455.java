package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09455")
public class BenchmarkTest09455 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72224 = param; //assign
		StringBuilder b72224 = new StringBuilder(a72224);  // stick in stringbuilder
		b72224.append(" SafeStuff"); // append some safe content
		b72224.replace(b72224.length()-"Chars".length(),b72224.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72224 = new java.util.HashMap<String,Object>();
		map72224.put("key72224", b72224.toString()); // put in a collection
		String c72224 = (String)map72224.get("key72224"); // get it back out
		String d72224 = c72224.substring(0,c72224.length()-1); // extract most of it
		String e72224 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72224.getBytes() ) )); // B64 encode and decode it
		String f72224 = e72224.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72224); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
