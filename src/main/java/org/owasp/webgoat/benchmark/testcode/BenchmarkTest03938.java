package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03938")
public class BenchmarkTest03938 extends HttpServlet {
	
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
		
		
		
		// Chain a bunch of propagators in sequence
		String a21909 = param; //assign
		StringBuilder b21909 = new StringBuilder(a21909);  // stick in stringbuilder
		b21909.append(" SafeStuff"); // append some safe content
		b21909.replace(b21909.length()-"Chars".length(),b21909.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21909 = new java.util.HashMap<String,Object>();
		map21909.put("key21909", b21909.toString()); // put in a collection
		String c21909 = (String)map21909.get("key21909"); // get it back out
		String d21909 = c21909.substring(0,c21909.length()-1); // extract most of it
		String e21909 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21909.getBytes() ) )); // B64 encode and decode it
		String f21909 = e21909.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21909); // reflection
		
		
	
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
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}
