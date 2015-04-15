package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19315")
public class BenchmarkTest19315 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76731 = param; //assign
		StringBuilder b76731 = new StringBuilder(a76731);  // stick in stringbuilder
		b76731.append(" SafeStuff"); // append some safe content
		b76731.replace(b76731.length()-"Chars".length(),b76731.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76731 = new java.util.HashMap<String,Object>();
		map76731.put("key76731", b76731.toString()); // put in a collection
		String c76731 = (String)map76731.get("key76731"); // get it back out
		String d76731 = c76731.substring(0,c76731.length()-1); // extract most of it
		String e76731 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76731.getBytes() ) )); // B64 encode and decode it
		String f76731 = e76731.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76731); // reflection
	
		return bar;	
	}
}
