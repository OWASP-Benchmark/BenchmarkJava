package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12239")
public class BenchmarkTest12239 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

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
		String a33748 = param; //assign
		StringBuilder b33748 = new StringBuilder(a33748);  // stick in stringbuilder
		b33748.append(" SafeStuff"); // append some safe content
		b33748.replace(b33748.length()-"Chars".length(),b33748.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33748 = new java.util.HashMap<String,Object>();
		map33748.put("key33748", b33748.toString()); // put in a collection
		String c33748 = (String)map33748.get("key33748"); // get it back out
		String d33748 = c33748.substring(0,c33748.length()-1); // extract most of it
		String e33748 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33748.getBytes() ) )); // B64 encode and decode it
		String f33748 = e33748.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f33748); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
