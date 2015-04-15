package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19423")
public class BenchmarkTest19423 extends HttpServlet {
	
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
		
		java.util.List<String> argList = new java.util.ArrayList<String>();
		
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	argList.add("cmd.exe");
        	argList.add("/c");
        } else {
        	argList.add("sh");
        	argList.add("-c");
        }
        argList.add("echo");
        argList.add(bar);

		ProcessBuilder pb = new ProcessBuilder(argList);

		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a49995 = param; //assign
		StringBuilder b49995 = new StringBuilder(a49995);  // stick in stringbuilder
		b49995.append(" SafeStuff"); // append some safe content
		b49995.replace(b49995.length()-"Chars".length(),b49995.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49995 = new java.util.HashMap<String,Object>();
		map49995.put("key49995", b49995.toString()); // put in a collection
		String c49995 = (String)map49995.get("key49995"); // get it back out
		String d49995 = c49995.substring(0,c49995.length()-1); // extract most of it
		String e49995 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49995.getBytes() ) )); // B64 encode and decode it
		String f49995 = e49995.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f49995); // reflection
	
		return bar;	
	}
}
