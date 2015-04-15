package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11335")
public class BenchmarkTest11335 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11600 = param; //assign
		StringBuilder b11600 = new StringBuilder(a11600);  // stick in stringbuilder
		b11600.append(" SafeStuff"); // append some safe content
		b11600.replace(b11600.length()-"Chars".length(),b11600.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11600 = new java.util.HashMap<String,Object>();
		map11600.put("key11600", b11600.toString()); // put in a collection
		String c11600 = (String)map11600.get("key11600"); // get it back out
		String d11600 = c11600.substring(0,c11600.length()-1); // extract most of it
		String e11600 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11600.getBytes() ) )); // B64 encode and decode it
		String f11600 = e11600.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f11600); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
