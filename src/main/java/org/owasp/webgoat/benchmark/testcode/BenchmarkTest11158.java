package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11158")
public class BenchmarkTest11158 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20018 = param; //assign
		StringBuilder b20018 = new StringBuilder(a20018);  // stick in stringbuilder
		b20018.append(" SafeStuff"); // append some safe content
		b20018.replace(b20018.length()-"Chars".length(),b20018.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20018 = new java.util.HashMap<String,Object>();
		map20018.put("key20018", b20018.toString()); // put in a collection
		String c20018 = (String)map20018.get("key20018"); // get it back out
		String d20018 = c20018.substring(0,c20018.length()-1); // extract most of it
		String e20018 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20018.getBytes() ) )); // B64 encode and decode it
		String f20018 = e20018.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20018); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
