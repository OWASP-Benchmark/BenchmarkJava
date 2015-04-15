package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18373")
public class BenchmarkTest18373 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a84008 = param; //assign
		StringBuilder b84008 = new StringBuilder(a84008);  // stick in stringbuilder
		b84008.append(" SafeStuff"); // append some safe content
		b84008.replace(b84008.length()-"Chars".length(),b84008.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84008 = new java.util.HashMap<String,Object>();
		map84008.put("key84008", b84008.toString()); // put in a collection
		String c84008 = (String)map84008.get("key84008"); // get it back out
		String d84008 = c84008.substring(0,c84008.length()-1); // extract most of it
		String e84008 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84008.getBytes() ) )); // B64 encode and decode it
		String f84008 = e84008.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84008 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84008); // reflection
	
		return bar;	
	}
}
