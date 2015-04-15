package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10968")
public class BenchmarkTest10968 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

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
		String a14603 = param; //assign
		StringBuilder b14603 = new StringBuilder(a14603);  // stick in stringbuilder
		b14603.append(" SafeStuff"); // append some safe content
		b14603.replace(b14603.length()-"Chars".length(),b14603.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14603 = new java.util.HashMap<String,Object>();
		map14603.put("key14603", b14603.toString()); // put in a collection
		String c14603 = (String)map14603.get("key14603"); // get it back out
		String d14603 = c14603.substring(0,c14603.length()-1); // extract most of it
		String e14603 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14603.getBytes() ) )); // B64 encode and decode it
		String f14603 = e14603.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g14603 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14603); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
