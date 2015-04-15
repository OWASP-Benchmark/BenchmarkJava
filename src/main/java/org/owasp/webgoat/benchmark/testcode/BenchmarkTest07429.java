package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07429")
public class BenchmarkTest07429 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24173 = param; //assign
		StringBuilder b24173 = new StringBuilder(a24173);  // stick in stringbuilder
		b24173.append(" SafeStuff"); // append some safe content
		b24173.replace(b24173.length()-"Chars".length(),b24173.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24173 = new java.util.HashMap<String,Object>();
		map24173.put("key24173", b24173.toString()); // put in a collection
		String c24173 = (String)map24173.get("key24173"); // get it back out
		String d24173 = c24173.substring(0,c24173.length()-1); // extract most of it
		String e24173 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24173.getBytes() ) )); // B64 encode and decode it
		String f24173 = e24173.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24173); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
