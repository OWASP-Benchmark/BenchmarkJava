package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10633")
public class BenchmarkTest10633 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43082 = param; //assign
		StringBuilder b43082 = new StringBuilder(a43082);  // stick in stringbuilder
		b43082.append(" SafeStuff"); // append some safe content
		b43082.replace(b43082.length()-"Chars".length(),b43082.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43082 = new java.util.HashMap<String,Object>();
		map43082.put("key43082", b43082.toString()); // put in a collection
		String c43082 = (String)map43082.get("key43082"); // get it back out
		String d43082 = c43082.substring(0,c43082.length()-1); // extract most of it
		String e43082 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43082.getBytes() ) )); // B64 encode and decode it
		String f43082 = e43082.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f43082); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
