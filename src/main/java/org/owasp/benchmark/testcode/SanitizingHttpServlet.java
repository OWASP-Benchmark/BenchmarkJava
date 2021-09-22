/**
 * OWASP Benchmark Project v1.2
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project. For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * @author Nick Sanidas
 * @created 2015
 */
package org.owasp.benchmark.testcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SanitizingHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected String sanitizeAttribute(String parameter) {
        String parameter1 = parameter;
        parameter1 = parameter1.replaceAll("'", "&#39;");
        parameter1 = parameter1.replaceAll("\"", "&quot;");
        parameter1 = parameter1.replaceAll("&", "&amp;");
        return parameter1;
    }

    protected String sanitizeTag(String parameter) {
        String parameter1 = parameter;
        parameter1 = parameter1.replaceAll("&", "&amp;");
        parameter1 = parameter1.replaceAll("<", "\\u003C");
        parameter1 = parameter1.replaceAll(">", "\\u003E");
        return parameter1;
    }

    protected String newSanitizedValue(String parameter) {
        parameter = parameter.replaceAll("&", "&amp;");
        parameter = parameter.replaceAll("<", "&lt;");
        parameter = parameter.replaceAll(">", "&gt;");
        return parameter;
    }
}
