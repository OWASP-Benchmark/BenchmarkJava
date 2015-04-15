package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08037")
public class BenchmarkTest08037 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95012 = param; //assign
		StringBuilder b95012 = new StringBuilder(a95012);  // stick in stringbuilder
		b95012.append(" SafeStuff"); // append some safe content
		b95012.replace(b95012.length()-"Chars".length(),b95012.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95012 = new java.util.HashMap<String,Object>();
		map95012.put("key95012", b95012.toString()); // put in a collection
		String c95012 = (String)map95012.get("key95012"); // get it back out
		String d95012 = c95012.substring(0,c95012.length()-1); // extract most of it
		String e95012 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95012.getBytes() ) )); // B64 encode and decode it
		String f95012 = e95012.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95012 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95012); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
