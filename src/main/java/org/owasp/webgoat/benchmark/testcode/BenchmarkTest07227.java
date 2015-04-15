package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07227")
public class BenchmarkTest07227 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4388 = param; //assign
		StringBuilder b4388 = new StringBuilder(a4388);  // stick in stringbuilder
		b4388.append(" SafeStuff"); // append some safe content
		b4388.replace(b4388.length()-"Chars".length(),b4388.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4388 = new java.util.HashMap<String,Object>();
		map4388.put("key4388", b4388.toString()); // put in a collection
		String c4388 = (String)map4388.get("key4388"); // get it back out
		String d4388 = c4388.substring(0,c4388.length()-1); // extract most of it
		String e4388 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4388.getBytes() ) )); // B64 encode and decode it
		String f4388 = e4388.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4388); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
