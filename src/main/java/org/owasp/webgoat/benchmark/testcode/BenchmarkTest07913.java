package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07913")
public class BenchmarkTest07913 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51021 = param; //assign
		StringBuilder b51021 = new StringBuilder(a51021);  // stick in stringbuilder
		b51021.append(" SafeStuff"); // append some safe content
		b51021.replace(b51021.length()-"Chars".length(),b51021.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51021 = new java.util.HashMap<String,Object>();
		map51021.put("key51021", b51021.toString()); // put in a collection
		String c51021 = (String)map51021.get("key51021"); // get it back out
		String d51021 = c51021.substring(0,c51021.length()-1); // extract most of it
		String e51021 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51021.getBytes() ) )); // B64 encode and decode it
		String f51021 = e51021.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51021 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51021); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
