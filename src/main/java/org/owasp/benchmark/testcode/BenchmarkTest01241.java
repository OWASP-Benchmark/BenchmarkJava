/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ldapi-00/BenchmarkTest01241")
public class BenchmarkTest01241 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest01241");
		if (param == null) param = "";

		String bar = new Test().doSomething(request, param);
		
	org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
	try {
		response.setContentType("text/html;charset=UTF-8");
		String base = "ou=users,ou=system";
		javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
		sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
		String filter = "(&(objectclass=person))(|(uid="+bar+")(street={0}))";
		Object[] filters = new Object[]{"The streetz 4 Ms bar"};

		javax.naming.directory.DirContext ctx = ads.getDirContext();
		javax.naming.directory.InitialDirContext idc = (javax.naming.directory.InitialDirContext) ctx;
		boolean found = false;
		javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results = 
				idc.search(base, filter,filters, sc);
		while (results.hasMore()) {
			javax.naming.directory.SearchResult sr = (javax.naming.directory.SearchResult) results.next();
			javax.naming.directory.Attributes attrs = sr.getAttributes();

			javax.naming.directory.Attribute attr = attrs.get("uid");
			javax.naming.directory.Attribute attr2 = attrs.get("street");
			if (attr != null){
				response.getWriter().println(
					"LDAP query results:<br>"
					+ "Record found with name " + attr.get() + "<br>"
					+ "Address: " + attr2.get()+ "<br>"
				);
				// System.out.println("record found " + attr.get());
				found = true;
			}
		}
		if (!found) {
			response.getWriter().println(
				"LDAP query results: nothing found for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(filter)
			);
		}
	} catch (javax.naming.NamingException e) {
		throw new ServletException(e);
	} finally {
    		try {
    			ads.closeDirContext();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar = "";
		if (param != null) {
			bar = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
			org.apache.commons.codec.binary.Base64.encodeBase64( param.getBytes() ) ));
		}

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
