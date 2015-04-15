package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11636")
public class BenchmarkTest11636 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92425 = param; //assign
		StringBuilder b92425 = new StringBuilder(a92425);  // stick in stringbuilder
		b92425.append(" SafeStuff"); // append some safe content
		b92425.replace(b92425.length()-"Chars".length(),b92425.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92425 = new java.util.HashMap<String,Object>();
		map92425.put("key92425", b92425.toString()); // put in a collection
		String c92425 = (String)map92425.get("key92425"); // get it back out
		String d92425 = c92425.substring(0,c92425.length()-1); // extract most of it
		String e92425 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92425.getBytes() ) )); // B64 encode and decode it
		String f92425 = e92425.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92425 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92425); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
