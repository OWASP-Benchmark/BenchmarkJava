package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07424")
public class BenchmarkTest07424 extends HttpServlet {
	
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
		String a10280 = param; //assign
		StringBuilder b10280 = new StringBuilder(a10280);  // stick in stringbuilder
		b10280.append(" SafeStuff"); // append some safe content
		b10280.replace(b10280.length()-"Chars".length(),b10280.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10280 = new java.util.HashMap<String,Object>();
		map10280.put("key10280", b10280.toString()); // put in a collection
		String c10280 = (String)map10280.get("key10280"); // get it back out
		String d10280 = c10280.substring(0,c10280.length()-1); // extract most of it
		String e10280 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10280.getBytes() ) )); // B64 encode and decode it
		String f10280 = e10280.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10280); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
