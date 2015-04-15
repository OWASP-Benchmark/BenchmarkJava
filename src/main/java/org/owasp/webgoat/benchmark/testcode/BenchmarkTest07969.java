package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07969")
public class BenchmarkTest07969 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24214 = param; //assign
		StringBuilder b24214 = new StringBuilder(a24214);  // stick in stringbuilder
		b24214.append(" SafeStuff"); // append some safe content
		b24214.replace(b24214.length()-"Chars".length(),b24214.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24214 = new java.util.HashMap<String,Object>();
		map24214.put("key24214", b24214.toString()); // put in a collection
		String c24214 = (String)map24214.get("key24214"); // get it back out
		String d24214 = c24214.substring(0,c24214.length()-1); // extract most of it
		String e24214 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24214.getBytes() ) )); // B64 encode and decode it
		String f24214 = e24214.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g24214 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g24214); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
