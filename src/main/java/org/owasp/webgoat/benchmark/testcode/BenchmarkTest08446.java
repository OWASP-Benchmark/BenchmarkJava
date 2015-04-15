package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08446")
public class BenchmarkTest08446 extends HttpServlet {
	
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
			xp.evaluate(bar, "SpecifiedContext");
		} catch (javax.xml.xpath.XPathExpressionException|java.lang.NullPointerException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34194 = param; //assign
		StringBuilder b34194 = new StringBuilder(a34194);  // stick in stringbuilder
		b34194.append(" SafeStuff"); // append some safe content
		b34194.replace(b34194.length()-"Chars".length(),b34194.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34194 = new java.util.HashMap<String,Object>();
		map34194.put("key34194", b34194.toString()); // put in a collection
		String c34194 = (String)map34194.get("key34194"); // get it back out
		String d34194 = c34194.substring(0,c34194.length()-1); // extract most of it
		String e34194 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34194.getBytes() ) )); // B64 encode and decode it
		String f34194 = e34194.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g34194 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34194); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
