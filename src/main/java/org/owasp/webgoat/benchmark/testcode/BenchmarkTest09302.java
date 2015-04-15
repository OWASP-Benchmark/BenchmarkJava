package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09302")
public class BenchmarkTest09302 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10444 = param; //assign
		StringBuilder b10444 = new StringBuilder(a10444);  // stick in stringbuilder
		b10444.append(" SafeStuff"); // append some safe content
		b10444.replace(b10444.length()-"Chars".length(),b10444.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10444 = new java.util.HashMap<String,Object>();
		map10444.put("key10444", b10444.toString()); // put in a collection
		String c10444 = (String)map10444.get("key10444"); // get it back out
		String d10444 = c10444.substring(0,c10444.length()-1); // extract most of it
		String e10444 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10444.getBytes() ) )); // B64 encode and decode it
		String f10444 = e10444.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10444); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
