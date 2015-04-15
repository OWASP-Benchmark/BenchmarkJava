package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17043")
public class BenchmarkTest17043 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a56869 = param; //assign
		StringBuilder b56869 = new StringBuilder(a56869);  // stick in stringbuilder
		b56869.append(" SafeStuff"); // append some safe content
		b56869.replace(b56869.length()-"Chars".length(),b56869.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56869 = new java.util.HashMap<String,Object>();
		map56869.put("key56869", b56869.toString()); // put in a collection
		String c56869 = (String)map56869.get("key56869"); // get it back out
		String d56869 = c56869.substring(0,c56869.length()-1); // extract most of it
		String e56869 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56869.getBytes() ) )); // B64 encode and decode it
		String f56869 = e56869.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f56869); // reflection
	
		return bar;	
	}
}
