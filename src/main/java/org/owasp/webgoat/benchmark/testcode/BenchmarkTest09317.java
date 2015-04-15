package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09317")
public class BenchmarkTest09317 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5439 = param; //assign
		StringBuilder b5439 = new StringBuilder(a5439);  // stick in stringbuilder
		b5439.append(" SafeStuff"); // append some safe content
		b5439.replace(b5439.length()-"Chars".length(),b5439.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5439 = new java.util.HashMap<String,Object>();
		map5439.put("key5439", b5439.toString()); // put in a collection
		String c5439 = (String)map5439.get("key5439"); // get it back out
		String d5439 = c5439.substring(0,c5439.length()-1); // extract most of it
		String e5439 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5439.getBytes() ) )); // B64 encode and decode it
		String f5439 = e5439.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g5439 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5439); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
