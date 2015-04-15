package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17430")
public class BenchmarkTest17430 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30105 = param; //assign
		StringBuilder b30105 = new StringBuilder(a30105);  // stick in stringbuilder
		b30105.append(" SafeStuff"); // append some safe content
		b30105.replace(b30105.length()-"Chars".length(),b30105.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30105 = new java.util.HashMap<String,Object>();
		map30105.put("key30105", b30105.toString()); // put in a collection
		String c30105 = (String)map30105.get("key30105"); // get it back out
		String d30105 = c30105.substring(0,c30105.length()-1); // extract most of it
		String e30105 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30105.getBytes() ) )); // B64 encode and decode it
		String f30105 = e30105.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30105); // reflection
	
		return bar;	
	}
}
