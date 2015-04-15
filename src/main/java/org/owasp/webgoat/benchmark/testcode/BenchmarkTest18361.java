package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18361")
public class BenchmarkTest18361 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77853 = param; //assign
		StringBuilder b77853 = new StringBuilder(a77853);  // stick in stringbuilder
		b77853.append(" SafeStuff"); // append some safe content
		b77853.replace(b77853.length()-"Chars".length(),b77853.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77853 = new java.util.HashMap<String,Object>();
		map77853.put("key77853", b77853.toString()); // put in a collection
		String c77853 = (String)map77853.get("key77853"); // get it back out
		String d77853 = c77853.substring(0,c77853.length()-1); // extract most of it
		String e77853 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77853.getBytes() ) )); // B64 encode and decode it
		String f77853 = e77853.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77853); // reflection
	
		return bar;	
	}
}
