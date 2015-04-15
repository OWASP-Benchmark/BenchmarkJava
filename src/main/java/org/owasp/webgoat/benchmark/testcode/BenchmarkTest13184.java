package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13184")
public class BenchmarkTest13184 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72789 = param; //assign
		StringBuilder b72789 = new StringBuilder(a72789);  // stick in stringbuilder
		b72789.append(" SafeStuff"); // append some safe content
		b72789.replace(b72789.length()-"Chars".length(),b72789.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72789 = new java.util.HashMap<String,Object>();
		map72789.put("key72789", b72789.toString()); // put in a collection
		String c72789 = (String)map72789.get("key72789"); // get it back out
		String d72789 = c72789.substring(0,c72789.length()-1); // extract most of it
		String e72789 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72789.getBytes() ) )); // B64 encode and decode it
		String f72789 = e72789.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g72789 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72789); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
