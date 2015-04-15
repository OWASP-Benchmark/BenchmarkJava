package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13006")
public class BenchmarkTest13006 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19903 = param; //assign
		StringBuilder b19903 = new StringBuilder(a19903);  // stick in stringbuilder
		b19903.append(" SafeStuff"); // append some safe content
		b19903.replace(b19903.length()-"Chars".length(),b19903.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19903 = new java.util.HashMap<String,Object>();
		map19903.put("key19903", b19903.toString()); // put in a collection
		String c19903 = (String)map19903.get("key19903"); // get it back out
		String d19903 = c19903.substring(0,c19903.length()-1); // extract most of it
		String e19903 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19903.getBytes() ) )); // B64 encode and decode it
		String f19903 = e19903.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f19903); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
