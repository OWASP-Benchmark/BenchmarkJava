package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08718")
public class BenchmarkTest08718 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a13386 = param; //assign
		StringBuilder b13386 = new StringBuilder(a13386);  // stick in stringbuilder
		b13386.append(" SafeStuff"); // append some safe content
		b13386.replace(b13386.length()-"Chars".length(),b13386.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13386 = new java.util.HashMap<String,Object>();
		map13386.put("key13386", b13386.toString()); // put in a collection
		String c13386 = (String)map13386.get("key13386"); // get it back out
		String d13386 = c13386.substring(0,c13386.length()-1); // extract most of it
		String e13386 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13386.getBytes() ) )); // B64 encode and decode it
		String f13386 = e13386.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13386 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13386); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
