package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10668")
public class BenchmarkTest10668 extends HttpServlet {
	
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
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50289 = param; //assign
		StringBuilder b50289 = new StringBuilder(a50289);  // stick in stringbuilder
		b50289.append(" SafeStuff"); // append some safe content
		b50289.replace(b50289.length()-"Chars".length(),b50289.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50289 = new java.util.HashMap<String,Object>();
		map50289.put("key50289", b50289.toString()); // put in a collection
		String c50289 = (String)map50289.get("key50289"); // get it back out
		String d50289 = c50289.substring(0,c50289.length()-1); // extract most of it
		String e50289 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50289.getBytes() ) )); // B64 encode and decode it
		String f50289 = e50289.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g50289 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g50289); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
