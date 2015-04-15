package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07215")
public class BenchmarkTest07215 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a22846 = param; //assign
		StringBuilder b22846 = new StringBuilder(a22846);  // stick in stringbuilder
		b22846.append(" SafeStuff"); // append some safe content
		b22846.replace(b22846.length()-"Chars".length(),b22846.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22846 = new java.util.HashMap<String,Object>();
		map22846.put("key22846", b22846.toString()); // put in a collection
		String c22846 = (String)map22846.get("key22846"); // get it back out
		String d22846 = c22846.substring(0,c22846.length()-1); // extract most of it
		String e22846 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22846.getBytes() ) )); // B64 encode and decode it
		String f22846 = e22846.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f22846); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
