package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17275")
public class BenchmarkTest17275 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76839 = param; //assign
		StringBuilder b76839 = new StringBuilder(a76839);  // stick in stringbuilder
		b76839.append(" SafeStuff"); // append some safe content
		b76839.replace(b76839.length()-"Chars".length(),b76839.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76839 = new java.util.HashMap<String,Object>();
		map76839.put("key76839", b76839.toString()); // put in a collection
		String c76839 = (String)map76839.get("key76839"); // get it back out
		String d76839 = c76839.substring(0,c76839.length()-1); // extract most of it
		String e76839 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76839.getBytes() ) )); // B64 encode and decode it
		String f76839 = e76839.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76839 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76839); // reflection
	
		return bar;	
	}
}
