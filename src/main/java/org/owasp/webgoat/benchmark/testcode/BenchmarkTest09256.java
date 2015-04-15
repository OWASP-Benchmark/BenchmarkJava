package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09256")
public class BenchmarkTest09256 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95845 = param; //assign
		StringBuilder b95845 = new StringBuilder(a95845);  // stick in stringbuilder
		b95845.append(" SafeStuff"); // append some safe content
		b95845.replace(b95845.length()-"Chars".length(),b95845.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95845 = new java.util.HashMap<String,Object>();
		map95845.put("key95845", b95845.toString()); // put in a collection
		String c95845 = (String)map95845.get("key95845"); // get it back out
		String d95845 = c95845.substring(0,c95845.length()-1); // extract most of it
		String e95845 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95845.getBytes() ) )); // B64 encode and decode it
		String f95845 = e95845.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95845 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95845); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
