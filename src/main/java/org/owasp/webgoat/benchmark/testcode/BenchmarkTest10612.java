package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10612")
public class BenchmarkTest10612 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26477 = param; //assign
		StringBuilder b26477 = new StringBuilder(a26477);  // stick in stringbuilder
		b26477.append(" SafeStuff"); // append some safe content
		b26477.replace(b26477.length()-"Chars".length(),b26477.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26477 = new java.util.HashMap<String,Object>();
		map26477.put("key26477", b26477.toString()); // put in a collection
		String c26477 = (String)map26477.get("key26477"); // get it back out
		String d26477 = c26477.substring(0,c26477.length()-1); // extract most of it
		String e26477 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26477.getBytes() ) )); // B64 encode and decode it
		String f26477 = e26477.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g26477 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26477); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
