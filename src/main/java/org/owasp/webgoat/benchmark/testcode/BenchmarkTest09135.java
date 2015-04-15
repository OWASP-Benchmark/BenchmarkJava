package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09135")
public class BenchmarkTest09135 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45765 = param; //assign
		StringBuilder b45765 = new StringBuilder(a45765);  // stick in stringbuilder
		b45765.append(" SafeStuff"); // append some safe content
		b45765.replace(b45765.length()-"Chars".length(),b45765.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45765 = new java.util.HashMap<String,Object>();
		map45765.put("key45765", b45765.toString()); // put in a collection
		String c45765 = (String)map45765.get("key45765"); // get it back out
		String d45765 = c45765.substring(0,c45765.length()-1); // extract most of it
		String e45765 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45765.getBytes() ) )); // B64 encode and decode it
		String f45765 = e45765.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45765 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45765); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
