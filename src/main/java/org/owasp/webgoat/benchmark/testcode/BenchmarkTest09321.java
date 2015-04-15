package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09321")
public class BenchmarkTest09321 extends HttpServlet {
	
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
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28141 = param; //assign
		StringBuilder b28141 = new StringBuilder(a28141);  // stick in stringbuilder
		b28141.append(" SafeStuff"); // append some safe content
		b28141.replace(b28141.length()-"Chars".length(),b28141.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28141 = new java.util.HashMap<String,Object>();
		map28141.put("key28141", b28141.toString()); // put in a collection
		String c28141 = (String)map28141.get("key28141"); // get it back out
		String d28141 = c28141.substring(0,c28141.length()-1); // extract most of it
		String e28141 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28141.getBytes() ) )); // B64 encode and decode it
		String f28141 = e28141.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g28141 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28141); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
