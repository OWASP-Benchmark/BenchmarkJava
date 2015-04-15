package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13940")
public class BenchmarkTest13940 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3962 = param; //assign
		StringBuilder b3962 = new StringBuilder(a3962);  // stick in stringbuilder
		b3962.append(" SafeStuff"); // append some safe content
		b3962.replace(b3962.length()-"Chars".length(),b3962.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3962 = new java.util.HashMap<String,Object>();
		map3962.put("key3962", b3962.toString()); // put in a collection
		String c3962 = (String)map3962.get("key3962"); // get it back out
		String d3962 = c3962.substring(0,c3962.length()-1); // extract most of it
		String e3962 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3962.getBytes() ) )); // B64 encode and decode it
		String f3962 = e3962.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g3962 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g3962); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
