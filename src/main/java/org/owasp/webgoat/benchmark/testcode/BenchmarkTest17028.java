package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17028")
public class BenchmarkTest17028 extends HttpServlet {
	
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
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35249 = param; //assign
		StringBuilder b35249 = new StringBuilder(a35249);  // stick in stringbuilder
		b35249.append(" SafeStuff"); // append some safe content
		b35249.replace(b35249.length()-"Chars".length(),b35249.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35249 = new java.util.HashMap<String,Object>();
		map35249.put("key35249", b35249.toString()); // put in a collection
		String c35249 = (String)map35249.get("key35249"); // get it back out
		String d35249 = c35249.substring(0,c35249.length()-1); // extract most of it
		String e35249 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35249.getBytes() ) )); // B64 encode and decode it
		String f35249 = e35249.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35249); // reflection
	
		return bar;	
	}
}
