package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07217")
public class BenchmarkTest07217 extends HttpServlet {
	
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
		String a13198 = param; //assign
		StringBuilder b13198 = new StringBuilder(a13198);  // stick in stringbuilder
		b13198.append(" SafeStuff"); // append some safe content
		b13198.replace(b13198.length()-"Chars".length(),b13198.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13198 = new java.util.HashMap<String,Object>();
		map13198.put("key13198", b13198.toString()); // put in a collection
		String c13198 = (String)map13198.get("key13198"); // get it back out
		String d13198 = c13198.substring(0,c13198.length()-1); // extract most of it
		String e13198 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13198.getBytes() ) )); // B64 encode and decode it
		String f13198 = e13198.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13198 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13198); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
