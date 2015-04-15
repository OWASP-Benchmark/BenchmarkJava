package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10678")
public class BenchmarkTest10678 extends HttpServlet {
	
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
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23927 = param; //assign
		StringBuilder b23927 = new StringBuilder(a23927);  // stick in stringbuilder
		b23927.append(" SafeStuff"); // append some safe content
		b23927.replace(b23927.length()-"Chars".length(),b23927.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23927 = new java.util.HashMap<String,Object>();
		map23927.put("key23927", b23927.toString()); // put in a collection
		String c23927 = (String)map23927.get("key23927"); // get it back out
		String d23927 = c23927.substring(0,c23927.length()-1); // extract most of it
		String e23927 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23927.getBytes() ) )); // B64 encode and decode it
		String f23927 = e23927.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23927 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23927); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
