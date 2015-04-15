package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11577")
public class BenchmarkTest11577 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

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
		String a96995 = param; //assign
		StringBuilder b96995 = new StringBuilder(a96995);  // stick in stringbuilder
		b96995.append(" SafeStuff"); // append some safe content
		b96995.replace(b96995.length()-"Chars".length(),b96995.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96995 = new java.util.HashMap<String,Object>();
		map96995.put("key96995", b96995.toString()); // put in a collection
		String c96995 = (String)map96995.get("key96995"); // get it back out
		String d96995 = c96995.substring(0,c96995.length()-1); // extract most of it
		String e96995 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96995.getBytes() ) )); // B64 encode and decode it
		String f96995 = e96995.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96995); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
