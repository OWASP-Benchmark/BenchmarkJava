package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12843")
public class BenchmarkTest12843 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

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
		String a26810 = param; //assign
		StringBuilder b26810 = new StringBuilder(a26810);  // stick in stringbuilder
		b26810.append(" SafeStuff"); // append some safe content
		b26810.replace(b26810.length()-"Chars".length(),b26810.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26810 = new java.util.HashMap<String,Object>();
		map26810.put("key26810", b26810.toString()); // put in a collection
		String c26810 = (String)map26810.get("key26810"); // get it back out
		String d26810 = c26810.substring(0,c26810.length()-1); // extract most of it
		String e26810 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26810.getBytes() ) )); // B64 encode and decode it
		String f26810 = e26810.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g26810 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26810); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
