package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13176")
public class BenchmarkTest13176 extends HttpServlet {
	
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
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a59244 = param; //assign
		StringBuilder b59244 = new StringBuilder(a59244);  // stick in stringbuilder
		b59244.append(" SafeStuff"); // append some safe content
		b59244.replace(b59244.length()-"Chars".length(),b59244.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59244 = new java.util.HashMap<String,Object>();
		map59244.put("key59244", b59244.toString()); // put in a collection
		String c59244 = (String)map59244.get("key59244"); // get it back out
		String d59244 = c59244.substring(0,c59244.length()-1); // extract most of it
		String e59244 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59244.getBytes() ) )); // B64 encode and decode it
		String f59244 = e59244.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f59244); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
