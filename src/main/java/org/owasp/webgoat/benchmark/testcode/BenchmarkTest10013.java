package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10013")
public class BenchmarkTest10013 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91951 = param; //assign
		StringBuilder b91951 = new StringBuilder(a91951);  // stick in stringbuilder
		b91951.append(" SafeStuff"); // append some safe content
		b91951.replace(b91951.length()-"Chars".length(),b91951.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91951 = new java.util.HashMap<String,Object>();
		map91951.put("key91951", b91951.toString()); // put in a collection
		String c91951 = (String)map91951.get("key91951"); // get it back out
		String d91951 = c91951.substring(0,c91951.length()-1); // extract most of it
		String e91951 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91951.getBytes() ) )); // B64 encode and decode it
		String f91951 = e91951.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g91951 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91951); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
