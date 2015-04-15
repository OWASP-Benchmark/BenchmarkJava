package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10082")
public class BenchmarkTest10082 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a57699 = param; //assign
		StringBuilder b57699 = new StringBuilder(a57699);  // stick in stringbuilder
		b57699.append(" SafeStuff"); // append some safe content
		b57699.replace(b57699.length()-"Chars".length(),b57699.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57699 = new java.util.HashMap<String,Object>();
		map57699.put("key57699", b57699.toString()); // put in a collection
		String c57699 = (String)map57699.get("key57699"); // get it back out
		String d57699 = c57699.substring(0,c57699.length()-1); // extract most of it
		String e57699 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57699.getBytes() ) )); // B64 encode and decode it
		String f57699 = e57699.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g57699 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g57699); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
