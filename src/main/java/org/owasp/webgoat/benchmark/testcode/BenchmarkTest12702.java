package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12702")
public class BenchmarkTest12702 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33108 = param; //assign
		StringBuilder b33108 = new StringBuilder(a33108);  // stick in stringbuilder
		b33108.append(" SafeStuff"); // append some safe content
		b33108.replace(b33108.length()-"Chars".length(),b33108.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33108 = new java.util.HashMap<String,Object>();
		map33108.put("key33108", b33108.toString()); // put in a collection
		String c33108 = (String)map33108.get("key33108"); // get it back out
		String d33108 = c33108.substring(0,c33108.length()-1); // extract most of it
		String e33108 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33108.getBytes() ) )); // B64 encode and decode it
		String f33108 = e33108.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g33108 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g33108); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
