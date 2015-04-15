package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13204")
public class BenchmarkTest13204 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87920 = param; //assign
		StringBuilder b87920 = new StringBuilder(a87920);  // stick in stringbuilder
		b87920.append(" SafeStuff"); // append some safe content
		b87920.replace(b87920.length()-"Chars".length(),b87920.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87920 = new java.util.HashMap<String,Object>();
		map87920.put("key87920", b87920.toString()); // put in a collection
		String c87920 = (String)map87920.get("key87920"); // get it back out
		String d87920 = c87920.substring(0,c87920.length()-1); // extract most of it
		String e87920 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87920.getBytes() ) )); // B64 encode and decode it
		String f87920 = e87920.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87920 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87920); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
