package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11304")
public class BenchmarkTest11304 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85870 = param; //assign
		StringBuilder b85870 = new StringBuilder(a85870);  // stick in stringbuilder
		b85870.append(" SafeStuff"); // append some safe content
		b85870.replace(b85870.length()-"Chars".length(),b85870.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85870 = new java.util.HashMap<String,Object>();
		map85870.put("key85870", b85870.toString()); // put in a collection
		String c85870 = (String)map85870.get("key85870"); // get it back out
		String d85870 = c85870.substring(0,c85870.length()-1); // extract most of it
		String e85870 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85870.getBytes() ) )); // B64 encode and decode it
		String f85870 = e85870.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85870); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
