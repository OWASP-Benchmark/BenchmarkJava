package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07649")
public class BenchmarkTest07649 extends HttpServlet {
	
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
		String a65961 = param; //assign
		StringBuilder b65961 = new StringBuilder(a65961);  // stick in stringbuilder
		b65961.append(" SafeStuff"); // append some safe content
		b65961.replace(b65961.length()-"Chars".length(),b65961.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65961 = new java.util.HashMap<String,Object>();
		map65961.put("key65961", b65961.toString()); // put in a collection
		String c65961 = (String)map65961.get("key65961"); // get it back out
		String d65961 = c65961.substring(0,c65961.length()-1); // extract most of it
		String e65961 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65961.getBytes() ) )); // B64 encode and decode it
		String f65961 = e65961.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g65961 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g65961); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
