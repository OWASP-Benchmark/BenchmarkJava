package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12481")
public class BenchmarkTest12481 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10741 = param; //assign
		StringBuilder b10741 = new StringBuilder(a10741);  // stick in stringbuilder
		b10741.append(" SafeStuff"); // append some safe content
		b10741.replace(b10741.length()-"Chars".length(),b10741.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10741 = new java.util.HashMap<String,Object>();
		map10741.put("key10741", b10741.toString()); // put in a collection
		String c10741 = (String)map10741.get("key10741"); // get it back out
		String d10741 = c10741.substring(0,c10741.length()-1); // extract most of it
		String e10741 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10741.getBytes() ) )); // B64 encode and decode it
		String f10741 = e10741.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10741 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10741); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
