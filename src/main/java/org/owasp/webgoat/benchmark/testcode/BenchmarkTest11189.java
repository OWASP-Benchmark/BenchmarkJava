package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11189")
public class BenchmarkTest11189 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43783 = param; //assign
		StringBuilder b43783 = new StringBuilder(a43783);  // stick in stringbuilder
		b43783.append(" SafeStuff"); // append some safe content
		b43783.replace(b43783.length()-"Chars".length(),b43783.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43783 = new java.util.HashMap<String,Object>();
		map43783.put("key43783", b43783.toString()); // put in a collection
		String c43783 = (String)map43783.get("key43783"); // get it back out
		String d43783 = c43783.substring(0,c43783.length()-1); // extract most of it
		String e43783 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43783.getBytes() ) )); // B64 encode and decode it
		String f43783 = e43783.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43783 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43783); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
