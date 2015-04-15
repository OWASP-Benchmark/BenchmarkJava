package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12291")
public class BenchmarkTest12291 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87143 = param; //assign
		StringBuilder b87143 = new StringBuilder(a87143);  // stick in stringbuilder
		b87143.append(" SafeStuff"); // append some safe content
		b87143.replace(b87143.length()-"Chars".length(),b87143.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87143 = new java.util.HashMap<String,Object>();
		map87143.put("key87143", b87143.toString()); // put in a collection
		String c87143 = (String)map87143.get("key87143"); // get it back out
		String d87143 = c87143.substring(0,c87143.length()-1); // extract most of it
		String e87143 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87143.getBytes() ) )); // B64 encode and decode it
		String f87143 = e87143.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87143 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87143); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
