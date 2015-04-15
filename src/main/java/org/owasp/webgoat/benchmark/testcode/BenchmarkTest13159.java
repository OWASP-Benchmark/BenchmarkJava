package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13159")
public class BenchmarkTest13159 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29608 = param; //assign
		StringBuilder b29608 = new StringBuilder(a29608);  // stick in stringbuilder
		b29608.append(" SafeStuff"); // append some safe content
		b29608.replace(b29608.length()-"Chars".length(),b29608.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29608 = new java.util.HashMap<String,Object>();
		map29608.put("key29608", b29608.toString()); // put in a collection
		String c29608 = (String)map29608.get("key29608"); // get it back out
		String d29608 = c29608.substring(0,c29608.length()-1); // extract most of it
		String e29608 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29608.getBytes() ) )); // B64 encode and decode it
		String f29608 = e29608.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29608); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
