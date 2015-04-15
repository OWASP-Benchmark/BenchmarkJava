package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10539")
public class BenchmarkTest10539 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90154 = param; //assign
		StringBuilder b90154 = new StringBuilder(a90154);  // stick in stringbuilder
		b90154.append(" SafeStuff"); // append some safe content
		b90154.replace(b90154.length()-"Chars".length(),b90154.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90154 = new java.util.HashMap<String,Object>();
		map90154.put("key90154", b90154.toString()); // put in a collection
		String c90154 = (String)map90154.get("key90154"); // get it back out
		String d90154 = c90154.substring(0,c90154.length()-1); // extract most of it
		String e90154 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90154.getBytes() ) )); // B64 encode and decode it
		String f90154 = e90154.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90154); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
