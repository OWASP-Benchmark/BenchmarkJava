package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15033")
public class BenchmarkTest15033 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
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

		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10499 = param; //assign
		StringBuilder b10499 = new StringBuilder(a10499);  // stick in stringbuilder
		b10499.append(" SafeStuff"); // append some safe content
		b10499.replace(b10499.length()-"Chars".length(),b10499.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10499 = new java.util.HashMap<String,Object>();
		map10499.put("key10499", b10499.toString()); // put in a collection
		String c10499 = (String)map10499.get("key10499"); // get it back out
		String d10499 = c10499.substring(0,c10499.length()-1); // extract most of it
		String e10499 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10499.getBytes() ) )); // B64 encode and decode it
		String f10499 = e10499.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10499); // reflection
	
		return bar;	
	}
}
