package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09333")
public class BenchmarkTest09333 extends HttpServlet {
	
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
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a99989 = param; //assign
		StringBuilder b99989 = new StringBuilder(a99989);  // stick in stringbuilder
		b99989.append(" SafeStuff"); // append some safe content
		b99989.replace(b99989.length()-"Chars".length(),b99989.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99989 = new java.util.HashMap<String,Object>();
		map99989.put("key99989", b99989.toString()); // put in a collection
		String c99989 = (String)map99989.get("key99989"); // get it back out
		String d99989 = c99989.substring(0,c99989.length()-1); // extract most of it
		String e99989 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99989.getBytes() ) )); // B64 encode and decode it
		String f99989 = e99989.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g99989 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g99989); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
