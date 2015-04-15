package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07454")
public class BenchmarkTest07454 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a48570 = param; //assign
		StringBuilder b48570 = new StringBuilder(a48570);  // stick in stringbuilder
		b48570.append(" SafeStuff"); // append some safe content
		b48570.replace(b48570.length()-"Chars".length(),b48570.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48570 = new java.util.HashMap<String,Object>();
		map48570.put("key48570", b48570.toString()); // put in a collection
		String c48570 = (String)map48570.get("key48570"); // get it back out
		String d48570 = c48570.substring(0,c48570.length()-1); // extract most of it
		String e48570 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48570.getBytes() ) )); // B64 encode and decode it
		String f48570 = e48570.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g48570 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g48570); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
