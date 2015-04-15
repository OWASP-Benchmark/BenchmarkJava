package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11071")
public class BenchmarkTest11071 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a16611 = param; //assign
		StringBuilder b16611 = new StringBuilder(a16611);  // stick in stringbuilder
		b16611.append(" SafeStuff"); // append some safe content
		b16611.replace(b16611.length()-"Chars".length(),b16611.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16611 = new java.util.HashMap<String,Object>();
		map16611.put("key16611", b16611.toString()); // put in a collection
		String c16611 = (String)map16611.get("key16611"); // get it back out
		String d16611 = c16611.substring(0,c16611.length()-1); // extract most of it
		String e16611 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16611.getBytes() ) )); // B64 encode and decode it
		String f16611 = e16611.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f16611); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
