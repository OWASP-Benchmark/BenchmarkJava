package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07345")
public class BenchmarkTest07345 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73797 = param; //assign
		StringBuilder b73797 = new StringBuilder(a73797);  // stick in stringbuilder
		b73797.append(" SafeStuff"); // append some safe content
		b73797.replace(b73797.length()-"Chars".length(),b73797.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73797 = new java.util.HashMap<String,Object>();
		map73797.put("key73797", b73797.toString()); // put in a collection
		String c73797 = (String)map73797.get("key73797"); // get it back out
		String d73797 = c73797.substring(0,c73797.length()-1); // extract most of it
		String e73797 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73797.getBytes() ) )); // B64 encode and decode it
		String f73797 = e73797.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73797); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
