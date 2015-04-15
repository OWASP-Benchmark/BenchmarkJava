package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07641")
public class BenchmarkTest07641 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75696 = param; //assign
		StringBuilder b75696 = new StringBuilder(a75696);  // stick in stringbuilder
		b75696.append(" SafeStuff"); // append some safe content
		b75696.replace(b75696.length()-"Chars".length(),b75696.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75696 = new java.util.HashMap<String,Object>();
		map75696.put("key75696", b75696.toString()); // put in a collection
		String c75696 = (String)map75696.get("key75696"); // get it back out
		String d75696 = c75696.substring(0,c75696.length()-1); // extract most of it
		String e75696 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75696.getBytes() ) )); // B64 encode and decode it
		String f75696 = e75696.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f75696); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
