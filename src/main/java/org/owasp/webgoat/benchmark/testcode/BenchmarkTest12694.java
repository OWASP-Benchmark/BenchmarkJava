package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12694")
public class BenchmarkTest12694 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87864 = param; //assign
		StringBuilder b87864 = new StringBuilder(a87864);  // stick in stringbuilder
		b87864.append(" SafeStuff"); // append some safe content
		b87864.replace(b87864.length()-"Chars".length(),b87864.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87864 = new java.util.HashMap<String,Object>();
		map87864.put("key87864", b87864.toString()); // put in a collection
		String c87864 = (String)map87864.get("key87864"); // get it back out
		String d87864 = c87864.substring(0,c87864.length()-1); // extract most of it
		String e87864 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87864.getBytes() ) )); // B64 encode and decode it
		String f87864 = e87864.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87864); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
