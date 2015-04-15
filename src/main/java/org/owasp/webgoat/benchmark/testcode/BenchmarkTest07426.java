package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07426")
public class BenchmarkTest07426 extends HttpServlet {
	
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
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88862 = param; //assign
		StringBuilder b88862 = new StringBuilder(a88862);  // stick in stringbuilder
		b88862.append(" SafeStuff"); // append some safe content
		b88862.replace(b88862.length()-"Chars".length(),b88862.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88862 = new java.util.HashMap<String,Object>();
		map88862.put("key88862", b88862.toString()); // put in a collection
		String c88862 = (String)map88862.get("key88862"); // get it back out
		String d88862 = c88862.substring(0,c88862.length()-1); // extract most of it
		String e88862 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88862.getBytes() ) )); // B64 encode and decode it
		String f88862 = e88862.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88862 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88862); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
