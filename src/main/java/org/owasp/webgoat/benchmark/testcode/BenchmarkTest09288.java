package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09288")
public class BenchmarkTest09288 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98595 = param; //assign
		StringBuilder b98595 = new StringBuilder(a98595);  // stick in stringbuilder
		b98595.append(" SafeStuff"); // append some safe content
		b98595.replace(b98595.length()-"Chars".length(),b98595.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98595 = new java.util.HashMap<String,Object>();
		map98595.put("key98595", b98595.toString()); // put in a collection
		String c98595 = (String)map98595.get("key98595"); // get it back out
		String d98595 = c98595.substring(0,c98595.length()-1); // extract most of it
		String e98595 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98595.getBytes() ) )); // B64 encode and decode it
		String f98595 = e98595.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g98595 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g98595); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
