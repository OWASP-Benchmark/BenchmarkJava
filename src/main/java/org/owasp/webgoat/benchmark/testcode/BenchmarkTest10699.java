package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10699")
public class BenchmarkTest10699 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11517 = param; //assign
		StringBuilder b11517 = new StringBuilder(a11517);  // stick in stringbuilder
		b11517.append(" SafeStuff"); // append some safe content
		b11517.replace(b11517.length()-"Chars".length(),b11517.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11517 = new java.util.HashMap<String,Object>();
		map11517.put("key11517", b11517.toString()); // put in a collection
		String c11517 = (String)map11517.get("key11517"); // get it back out
		String d11517 = c11517.substring(0,c11517.length()-1); // extract most of it
		String e11517 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11517.getBytes() ) )); // B64 encode and decode it
		String f11517 = e11517.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g11517 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11517); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
