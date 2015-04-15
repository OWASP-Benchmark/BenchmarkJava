package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10735")
public class BenchmarkTest10735 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43524 = param; //assign
		StringBuilder b43524 = new StringBuilder(a43524);  // stick in stringbuilder
		b43524.append(" SafeStuff"); // append some safe content
		b43524.replace(b43524.length()-"Chars".length(),b43524.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43524 = new java.util.HashMap<String,Object>();
		map43524.put("key43524", b43524.toString()); // put in a collection
		String c43524 = (String)map43524.get("key43524"); // get it back out
		String d43524 = c43524.substring(0,c43524.length()-1); // extract most of it
		String e43524 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43524.getBytes() ) )); // B64 encode and decode it
		String f43524 = e43524.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43524 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43524); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
