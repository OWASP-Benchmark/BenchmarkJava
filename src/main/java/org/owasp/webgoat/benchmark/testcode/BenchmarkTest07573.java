package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07573")
public class BenchmarkTest07573 extends HttpServlet {
	
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
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68070 = param; //assign
		StringBuilder b68070 = new StringBuilder(a68070);  // stick in stringbuilder
		b68070.append(" SafeStuff"); // append some safe content
		b68070.replace(b68070.length()-"Chars".length(),b68070.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68070 = new java.util.HashMap<String,Object>();
		map68070.put("key68070", b68070.toString()); // put in a collection
		String c68070 = (String)map68070.get("key68070"); // get it back out
		String d68070 = c68070.substring(0,c68070.length()-1); // extract most of it
		String e68070 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68070.getBytes() ) )); // B64 encode and decode it
		String f68070 = e68070.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g68070 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g68070); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
