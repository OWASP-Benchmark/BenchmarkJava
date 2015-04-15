package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09978")
public class BenchmarkTest09978 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(argList);
		
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
		String a34831 = param; //assign
		StringBuilder b34831 = new StringBuilder(a34831);  // stick in stringbuilder
		b34831.append(" SafeStuff"); // append some safe content
		b34831.replace(b34831.length()-"Chars".length(),b34831.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34831 = new java.util.HashMap<String,Object>();
		map34831.put("key34831", b34831.toString()); // put in a collection
		String c34831 = (String)map34831.get("key34831"); // get it back out
		String d34831 = c34831.substring(0,c34831.length()-1); // extract most of it
		String e34831 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34831.getBytes() ) )); // B64 encode and decode it
		String f34831 = e34831.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g34831 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34831); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
