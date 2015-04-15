package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10043")
public class BenchmarkTest10043 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76856 = param; //assign
		StringBuilder b76856 = new StringBuilder(a76856);  // stick in stringbuilder
		b76856.append(" SafeStuff"); // append some safe content
		b76856.replace(b76856.length()-"Chars".length(),b76856.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76856 = new java.util.HashMap<String,Object>();
		map76856.put("key76856", b76856.toString()); // put in a collection
		String c76856 = (String)map76856.get("key76856"); // get it back out
		String d76856 = c76856.substring(0,c76856.length()-1); // extract most of it
		String e76856 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76856.getBytes() ) )); // B64 encode and decode it
		String f76856 = e76856.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76856 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76856); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
