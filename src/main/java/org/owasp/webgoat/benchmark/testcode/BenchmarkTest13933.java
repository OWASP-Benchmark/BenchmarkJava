package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13933")
public class BenchmarkTest13933 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87426 = param; //assign
		StringBuilder b87426 = new StringBuilder(a87426);  // stick in stringbuilder
		b87426.append(" SafeStuff"); // append some safe content
		b87426.replace(b87426.length()-"Chars".length(),b87426.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87426 = new java.util.HashMap<String,Object>();
		map87426.put("key87426", b87426.toString()); // put in a collection
		String c87426 = (String)map87426.get("key87426"); // get it back out
		String d87426 = c87426.substring(0,c87426.length()-1); // extract most of it
		String e87426 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87426.getBytes() ) )); // B64 encode and decode it
		String f87426 = e87426.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87426 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87426); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
