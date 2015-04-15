package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09859")
public class BenchmarkTest09859 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a49392 = param; //assign
		StringBuilder b49392 = new StringBuilder(a49392);  // stick in stringbuilder
		b49392.append(" SafeStuff"); // append some safe content
		b49392.replace(b49392.length()-"Chars".length(),b49392.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49392 = new java.util.HashMap<String,Object>();
		map49392.put("key49392", b49392.toString()); // put in a collection
		String c49392 = (String)map49392.get("key49392"); // get it back out
		String d49392 = c49392.substring(0,c49392.length()-1); // extract most of it
		String e49392 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49392.getBytes() ) )); // B64 encode and decode it
		String f49392 = e49392.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49392 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49392); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
