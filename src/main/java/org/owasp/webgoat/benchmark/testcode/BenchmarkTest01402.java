package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01402")
public class BenchmarkTest01402 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a51647 = param; //assign
		StringBuilder b51647 = new StringBuilder(a51647);  // stick in stringbuilder
		b51647.append(" SafeStuff"); // append some safe content
		b51647.replace(b51647.length()-"Chars".length(),b51647.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51647 = new java.util.HashMap<String,Object>();
		map51647.put("key51647", b51647.toString()); // put in a collection
		String c51647 = (String)map51647.get("key51647"); // get it back out
		String d51647 = c51647.substring(0,c51647.length()-1); // extract most of it
		String e51647 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51647.getBytes() ) )); // B64 encode and decode it
		String f51647 = e51647.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51647); // reflection
		
		
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};
        
        String[] argsEnv = { "foo=bar" };
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}
