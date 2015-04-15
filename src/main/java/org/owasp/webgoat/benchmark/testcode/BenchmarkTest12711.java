package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12711")
public class BenchmarkTest12711 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4472 = param; //assign
		StringBuilder b4472 = new StringBuilder(a4472);  // stick in stringbuilder
		b4472.append(" SafeStuff"); // append some safe content
		b4472.replace(b4472.length()-"Chars".length(),b4472.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4472 = new java.util.HashMap<String,Object>();
		map4472.put("key4472", b4472.toString()); // put in a collection
		String c4472 = (String)map4472.get("key4472"); // get it back out
		String d4472 = c4472.substring(0,c4472.length()-1); // extract most of it
		String e4472 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4472.getBytes() ) )); // B64 encode and decode it
		String f4472 = e4472.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g4472 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g4472); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
