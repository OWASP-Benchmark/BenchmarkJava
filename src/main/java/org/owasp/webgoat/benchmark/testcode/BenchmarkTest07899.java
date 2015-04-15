package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07899")
public class BenchmarkTest07899 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35189 = param; //assign
		StringBuilder b35189 = new StringBuilder(a35189);  // stick in stringbuilder
		b35189.append(" SafeStuff"); // append some safe content
		b35189.replace(b35189.length()-"Chars".length(),b35189.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35189 = new java.util.HashMap<String,Object>();
		map35189.put("key35189", b35189.toString()); // put in a collection
		String c35189 = (String)map35189.get("key35189"); // get it back out
		String d35189 = c35189.substring(0,c35189.length()-1); // extract most of it
		String e35189 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35189.getBytes() ) )); // B64 encode and decode it
		String f35189 = e35189.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35189 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35189); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
