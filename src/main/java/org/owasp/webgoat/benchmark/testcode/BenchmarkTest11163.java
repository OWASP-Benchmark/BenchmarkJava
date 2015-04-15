package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11163")
public class BenchmarkTest11163 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98604 = param; //assign
		StringBuilder b98604 = new StringBuilder(a98604);  // stick in stringbuilder
		b98604.append(" SafeStuff"); // append some safe content
		b98604.replace(b98604.length()-"Chars".length(),b98604.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98604 = new java.util.HashMap<String,Object>();
		map98604.put("key98604", b98604.toString()); // put in a collection
		String c98604 = (String)map98604.get("key98604"); // get it back out
		String d98604 = c98604.substring(0,c98604.length()-1); // extract most of it
		String e98604 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98604.getBytes() ) )); // B64 encode and decode it
		String f98604 = e98604.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f98604); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
