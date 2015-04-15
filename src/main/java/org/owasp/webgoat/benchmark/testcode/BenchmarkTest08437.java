package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08437")
public class BenchmarkTest08437 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.compile(bar);
		} catch (javax.xml.xpath.XPathExpressionException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4185 = param; //assign
		StringBuilder b4185 = new StringBuilder(a4185);  // stick in stringbuilder
		b4185.append(" SafeStuff"); // append some safe content
		b4185.replace(b4185.length()-"Chars".length(),b4185.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4185 = new java.util.HashMap<String,Object>();
		map4185.put("key4185", b4185.toString()); // put in a collection
		String c4185 = (String)map4185.get("key4185"); // get it back out
		String d4185 = c4185.substring(0,c4185.length()-1); // extract most of it
		String e4185 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4185.getBytes() ) )); // B64 encode and decode it
		String f4185 = e4185.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4185); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
