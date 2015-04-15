package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08811")
public class BenchmarkTest08811 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92297 = param; //assign
		StringBuilder b92297 = new StringBuilder(a92297);  // stick in stringbuilder
		b92297.append(" SafeStuff"); // append some safe content
		b92297.replace(b92297.length()-"Chars".length(),b92297.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92297 = new java.util.HashMap<String,Object>();
		map92297.put("key92297", b92297.toString()); // put in a collection
		String c92297 = (String)map92297.get("key92297"); // get it back out
		String d92297 = c92297.substring(0,c92297.length()-1); // extract most of it
		String e92297 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92297.getBytes() ) )); // B64 encode and decode it
		String f92297 = e92297.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f92297); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
