package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12076")
public class BenchmarkTest12076 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15169 = param; //assign
		StringBuilder b15169 = new StringBuilder(a15169);  // stick in stringbuilder
		b15169.append(" SafeStuff"); // append some safe content
		b15169.replace(b15169.length()-"Chars".length(),b15169.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15169 = new java.util.HashMap<String,Object>();
		map15169.put("key15169", b15169.toString()); // put in a collection
		String c15169 = (String)map15169.get("key15169"); // get it back out
		String d15169 = c15169.substring(0,c15169.length()-1); // extract most of it
		String e15169 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15169.getBytes() ) )); // B64 encode and decode it
		String f15169 = e15169.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g15169 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g15169); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
