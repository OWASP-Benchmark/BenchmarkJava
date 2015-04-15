package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14210")
public class BenchmarkTest14210 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77719 = param; //assign
		StringBuilder b77719 = new StringBuilder(a77719);  // stick in stringbuilder
		b77719.append(" SafeStuff"); // append some safe content
		b77719.replace(b77719.length()-"Chars".length(),b77719.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77719 = new java.util.HashMap<String,Object>();
		map77719.put("key77719", b77719.toString()); // put in a collection
		String c77719 = (String)map77719.get("key77719"); // get it back out
		String d77719 = c77719.substring(0,c77719.length()-1); // extract most of it
		String e77719 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77719.getBytes() ) )); // B64 encode and decode it
		String f77719 = e77719.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77719); // reflection
	
		return bar;	
	}
}
