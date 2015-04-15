package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11583")
public class BenchmarkTest11583 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.security.Provider[] provider = java.security.Security.getProviders();
		javax.crypto.Cipher c;

		try {
			if (provider.length > 1) {
				c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5PADDING", java.security.Security.getProvider("SunJCE"));
			} else {
				c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5PADDING", java.security.Security.getProvider("SunJCE"));
			}
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			// throw new ServletException(e);
		/*} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			// throw new ServletException(e); ok for now to swallow this */
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			// throw new ServletException(e);
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a63583 = param; //assign
		StringBuilder b63583 = new StringBuilder(a63583);  // stick in stringbuilder
		b63583.append(" SafeStuff"); // append some safe content
		b63583.replace(b63583.length()-"Chars".length(),b63583.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63583 = new java.util.HashMap<String,Object>();
		map63583.put("key63583", b63583.toString()); // put in a collection
		String c63583 = (String)map63583.get("key63583"); // get it back out
		String d63583 = c63583.substring(0,c63583.length()-1); // extract most of it
		String e63583 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63583.getBytes() ) )); // B64 encode and decode it
		String f63583 = e63583.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g63583 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g63583); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
