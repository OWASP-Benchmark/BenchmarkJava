package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11023")
public class BenchmarkTest11023 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38292 = param; //assign
		StringBuilder b38292 = new StringBuilder(a38292);  // stick in stringbuilder
		b38292.append(" SafeStuff"); // append some safe content
		b38292.replace(b38292.length()-"Chars".length(),b38292.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38292 = new java.util.HashMap<String,Object>();
		map38292.put("key38292", b38292.toString()); // put in a collection
		String c38292 = (String)map38292.get("key38292"); // get it back out
		String d38292 = c38292.substring(0,c38292.length()-1); // extract most of it
		String e38292 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38292.getBytes() ) )); // B64 encode and decode it
		String f38292 = e38292.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g38292 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g38292); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
