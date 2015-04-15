package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09385")
public class BenchmarkTest09385 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
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

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75448 = param; //assign
		StringBuilder b75448 = new StringBuilder(a75448);  // stick in stringbuilder
		b75448.append(" SafeStuff"); // append some safe content
		b75448.replace(b75448.length()-"Chars".length(),b75448.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75448 = new java.util.HashMap<String,Object>();
		map75448.put("key75448", b75448.toString()); // put in a collection
		String c75448 = (String)map75448.get("key75448"); // get it back out
		String d75448 = c75448.substring(0,c75448.length()-1); // extract most of it
		String e75448 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75448.getBytes() ) )); // B64 encode and decode it
		String f75448 = e75448.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f75448); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
