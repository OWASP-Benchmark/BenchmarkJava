package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11321")
public class BenchmarkTest11321 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a244 = param; //assign
		StringBuilder b244 = new StringBuilder(a244);  // stick in stringbuilder
		b244.append(" SafeStuff"); // append some safe content
		b244.replace(b244.length()-"Chars".length(),b244.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map244 = new java.util.HashMap<String,Object>();
		map244.put("key244", b244.toString()); // put in a collection
		String c244 = (String)map244.get("key244"); // get it back out
		String d244 = c244.substring(0,c244.length()-1); // extract most of it
		String e244 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d244.getBytes() ) )); // B64 encode and decode it
		String f244 = e244.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g244 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g244); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
