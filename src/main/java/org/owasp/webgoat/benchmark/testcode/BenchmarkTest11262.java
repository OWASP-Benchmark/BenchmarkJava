package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11262")
public class BenchmarkTest11262 extends HttpServlet {
	
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
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5021 = param; //assign
		StringBuilder b5021 = new StringBuilder(a5021);  // stick in stringbuilder
		b5021.append(" SafeStuff"); // append some safe content
		b5021.replace(b5021.length()-"Chars".length(),b5021.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5021 = new java.util.HashMap<String,Object>();
		map5021.put("key5021", b5021.toString()); // put in a collection
		String c5021 = (String)map5021.get("key5021"); // get it back out
		String d5021 = c5021.substring(0,c5021.length()-1); // extract most of it
		String e5021 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5021.getBytes() ) )); // B64 encode and decode it
		String f5021 = e5021.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5021); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
