package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09191")
public class BenchmarkTest09191 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a57845 = param; //assign
		StringBuilder b57845 = new StringBuilder(a57845);  // stick in stringbuilder
		b57845.append(" SafeStuff"); // append some safe content
		b57845.replace(b57845.length()-"Chars".length(),b57845.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57845 = new java.util.HashMap<String,Object>();
		map57845.put("key57845", b57845.toString()); // put in a collection
		String c57845 = (String)map57845.get("key57845"); // get it back out
		String d57845 = c57845.substring(0,c57845.length()-1); // extract most of it
		String e57845 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57845.getBytes() ) )); // B64 encode and decode it
		String f57845 = e57845.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g57845 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g57845); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
