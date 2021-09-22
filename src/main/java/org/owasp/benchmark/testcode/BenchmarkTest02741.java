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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-00/BenchmarkTest02741")
public class BenchmarkTest02741 extends SanitizingHttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("X-XSS-Protection", "0");

        String param = request.getParameter("email");
        if (param == null) param = "";
        String sanitizeParam = sanitizeAttribute(param);

        String htmlResponse = "<html>";
        htmlResponse +=
                "<head></head><body><div class=\"col-sm-4\">\n"
                        + " <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Password\""
                        + " name='password' th:value='"
                        + sanitizeParam
                        + "'/>"
                        + " </div></body>";
        htmlResponse += "</html>";

        response.getWriter().println(htmlResponse);
    }
}
