package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07647")
public class BenchmarkTest07647 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4500 = param; //assign
		StringBuilder b4500 = new StringBuilder(a4500);  // stick in stringbuilder
		b4500.append(" SafeStuff"); // append some safe content
		b4500.replace(b4500.length()-"Chars".length(),b4500.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4500 = new java.util.HashMap<String,Object>();
		map4500.put("key4500", b4500.toString()); // put in a collection
		String c4500 = (String)map4500.get("key4500"); // get it back out
		String d4500 = c4500.substring(0,c4500.length()-1); // extract most of it
		String e4500 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4500.getBytes() ) )); // B64 encode and decode it
		String f4500 = e4500.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4500); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
