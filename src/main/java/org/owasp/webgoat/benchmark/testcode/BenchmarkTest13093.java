package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13093")
public class BenchmarkTest13093 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14219 = param; //assign
		StringBuilder b14219 = new StringBuilder(a14219);  // stick in stringbuilder
		b14219.append(" SafeStuff"); // append some safe content
		b14219.replace(b14219.length()-"Chars".length(),b14219.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14219 = new java.util.HashMap<String,Object>();
		map14219.put("key14219", b14219.toString()); // put in a collection
		String c14219 = (String)map14219.get("key14219"); // get it back out
		String d14219 = c14219.substring(0,c14219.length()-1); // extract most of it
		String e14219 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14219.getBytes() ) )); // B64 encode and decode it
		String f14219 = e14219.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14219); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
