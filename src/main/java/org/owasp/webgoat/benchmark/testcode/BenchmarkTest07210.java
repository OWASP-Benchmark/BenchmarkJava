package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07210")
public class BenchmarkTest07210 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26084 = param; //assign
		StringBuilder b26084 = new StringBuilder(a26084);  // stick in stringbuilder
		b26084.append(" SafeStuff"); // append some safe content
		b26084.replace(b26084.length()-"Chars".length(),b26084.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26084 = new java.util.HashMap<String,Object>();
		map26084.put("key26084", b26084.toString()); // put in a collection
		String c26084 = (String)map26084.get("key26084"); // get it back out
		String d26084 = c26084.substring(0,c26084.length()-1); // extract most of it
		String e26084 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26084.getBytes() ) )); // B64 encode and decode it
		String f26084 = e26084.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f26084); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
