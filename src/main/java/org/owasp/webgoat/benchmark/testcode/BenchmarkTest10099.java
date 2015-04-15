package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10099")
public class BenchmarkTest10099 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53808 = param; //assign
		StringBuilder b53808 = new StringBuilder(a53808);  // stick in stringbuilder
		b53808.append(" SafeStuff"); // append some safe content
		b53808.replace(b53808.length()-"Chars".length(),b53808.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53808 = new java.util.HashMap<String,Object>();
		map53808.put("key53808", b53808.toString()); // put in a collection
		String c53808 = (String)map53808.get("key53808"); // get it back out
		String d53808 = c53808.substring(0,c53808.length()-1); // extract most of it
		String e53808 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53808.getBytes() ) )); // B64 encode and decode it
		String f53808 = e53808.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g53808 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53808); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
