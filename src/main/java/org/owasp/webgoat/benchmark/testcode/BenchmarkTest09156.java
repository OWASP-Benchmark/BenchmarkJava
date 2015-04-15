package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09156")
public class BenchmarkTest09156 extends HttpServlet {
	
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
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26619 = param; //assign
		StringBuilder b26619 = new StringBuilder(a26619);  // stick in stringbuilder
		b26619.append(" SafeStuff"); // append some safe content
		b26619.replace(b26619.length()-"Chars".length(),b26619.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26619 = new java.util.HashMap<String,Object>();
		map26619.put("key26619", b26619.toString()); // put in a collection
		String c26619 = (String)map26619.get("key26619"); // get it back out
		String d26619 = c26619.substring(0,c26619.length()-1); // extract most of it
		String e26619 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26619.getBytes() ) )); // B64 encode and decode it
		String f26619 = e26619.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g26619 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26619); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
