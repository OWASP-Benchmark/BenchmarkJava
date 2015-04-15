package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08626")
public class BenchmarkTest08626 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1020 = param; //assign
		StringBuilder b1020 = new StringBuilder(a1020);  // stick in stringbuilder
		b1020.append(" SafeStuff"); // append some safe content
		b1020.replace(b1020.length()-"Chars".length(),b1020.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1020 = new java.util.HashMap<String,Object>();
		map1020.put("key1020", b1020.toString()); // put in a collection
		String c1020 = (String)map1020.get("key1020"); // get it back out
		String d1020 = c1020.substring(0,c1020.length()-1); // extract most of it
		String e1020 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1020.getBytes() ) )); // B64 encode and decode it
		String f1020 = e1020.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1020 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1020); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
