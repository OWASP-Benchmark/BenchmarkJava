package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13214")
public class BenchmarkTest13214 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a642 = param; //assign
		StringBuilder b642 = new StringBuilder(a642);  // stick in stringbuilder
		b642.append(" SafeStuff"); // append some safe content
		b642.replace(b642.length()-"Chars".length(),b642.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map642 = new java.util.HashMap<String,Object>();
		map642.put("key642", b642.toString()); // put in a collection
		String c642 = (String)map642.get("key642"); // get it back out
		String d642 = c642.substring(0,c642.length()-1); // extract most of it
		String e642 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d642.getBytes() ) )); // B64 encode and decode it
		String f642 = e642.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g642 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g642); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
