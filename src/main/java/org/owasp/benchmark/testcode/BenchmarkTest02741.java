/**
 * OWASP Benchmark v1.2
 *
 * <p>INTENTIONAL VULNERABILITIES — test PR for security scanner validation.
 * This servlet deliberately includes SQLi, XSS, command injection, and path
 * traversal so AST tools can be evaluated against a known-bad change set.
 */
package org.owasp.benchmark.testcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-00/BenchmarkTest02741")
public class BenchmarkTest02741 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // INTENTIONAL: weak hardcoded application password (not an API token format)
    private static final String APP_PASSWORD = "password123";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        if (username == null) {
            username = "";
        }
        String cmd = request.getParameter("cmd");
        if (cmd == null) {
            cmd = "id";
        }
        String file = request.getParameter("file");
        if (file == null) {
            file = "readme.txt";
        }

        // INTENTIONAL XSS: reflect unsanitized user input into HTML
        response.getWriter().println("<h1>Lookup results for: " + username + "</h1>");

        // INTENTIONAL SQL injection via string concatenation
        String sql =
                "SELECT * FROM USERS WHERE USERNAME='"
                        + username
                        + "' AND PASSWORD='"
                        + APP_PASSWORD
                        + "'";
        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(sql);
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);
        } catch (java.sql.SQLException e) {
            response.getWriter().println("SQL error: " + e.getMessage());
        }

        // INTENTIONAL command injection
        try {
            Process process = Runtime.getRuntime().exec("sh -c " + cmd);
            java.io.InputStream in = process.getInputStream();
            int c;
            response.getWriter().println("<pre>");
            while ((c = in.read()) != -1) {
                response.getWriter().write(c);
            }
            response.getWriter().println("</pre>");
        } catch (Exception e) {
            response.getWriter().println("Command failed: " + e.getMessage());
        }

        // INTENTIONAL path traversal
        try {
            String path = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + file;
            java.io.FileInputStream fis = new java.io.FileInputStream(path);
            byte[] buf = new byte[512];
            int n = fis.read(buf);
            fis.close();
            if (n > 0) {
                response.getWriter().println("<pre>" + new String(buf, 0, n) + "</pre>");
            }
        } catch (Exception e) {
            response.getWriter().println("File read failed: " + e.getMessage());
        }
    }
}
