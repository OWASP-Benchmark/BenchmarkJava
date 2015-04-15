package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09937")
public class BenchmarkTest09937 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7532 = param; //assign
		StringBuilder b7532 = new StringBuilder(a7532);  // stick in stringbuilder
		b7532.append(" SafeStuff"); // append some safe content
		b7532.replace(b7532.length()-"Chars".length(),b7532.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7532 = new java.util.HashMap<String,Object>();
		map7532.put("key7532", b7532.toString()); // put in a collection
		String c7532 = (String)map7532.get("key7532"); // get it back out
		String d7532 = c7532.substring(0,c7532.length()-1); // extract most of it
		String e7532 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7532.getBytes() ) )); // B64 encode and decode it
		String f7532 = e7532.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g7532 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g7532); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
