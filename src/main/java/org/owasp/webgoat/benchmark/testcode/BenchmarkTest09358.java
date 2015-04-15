package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09358")
public class BenchmarkTest09358 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a18360 = param; //assign
		StringBuilder b18360 = new StringBuilder(a18360);  // stick in stringbuilder
		b18360.append(" SafeStuff"); // append some safe content
		b18360.replace(b18360.length()-"Chars".length(),b18360.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18360 = new java.util.HashMap<String,Object>();
		map18360.put("key18360", b18360.toString()); // put in a collection
		String c18360 = (String)map18360.get("key18360"); // get it back out
		String d18360 = c18360.substring(0,c18360.length()-1); // extract most of it
		String e18360 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18360.getBytes() ) )); // B64 encode and decode it
		String f18360 = e18360.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18360 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18360); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
