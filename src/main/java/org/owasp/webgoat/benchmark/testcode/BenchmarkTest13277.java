package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13277")
public class BenchmarkTest13277 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66113 = param; //assign
		StringBuilder b66113 = new StringBuilder(a66113);  // stick in stringbuilder
		b66113.append(" SafeStuff"); // append some safe content
		b66113.replace(b66113.length()-"Chars".length(),b66113.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66113 = new java.util.HashMap<String,Object>();
		map66113.put("key66113", b66113.toString()); // put in a collection
		String c66113 = (String)map66113.get("key66113"); // get it back out
		String d66113 = c66113.substring(0,c66113.length()-1); // extract most of it
		String e66113 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66113.getBytes() ) )); // B64 encode and decode it
		String f66113 = e66113.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f66113); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
