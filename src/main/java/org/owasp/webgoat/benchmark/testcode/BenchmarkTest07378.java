package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07378")
public class BenchmarkTest07378 extends HttpServlet {
	
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
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a12078 = param; //assign
		StringBuilder b12078 = new StringBuilder(a12078);  // stick in stringbuilder
		b12078.append(" SafeStuff"); // append some safe content
		b12078.replace(b12078.length()-"Chars".length(),b12078.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12078 = new java.util.HashMap<String,Object>();
		map12078.put("key12078", b12078.toString()); // put in a collection
		String c12078 = (String)map12078.get("key12078"); // get it back out
		String d12078 = c12078.substring(0,c12078.length()-1); // extract most of it
		String e12078 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12078.getBytes() ) )); // B64 encode and decode it
		String f12078 = e12078.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g12078 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g12078); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
