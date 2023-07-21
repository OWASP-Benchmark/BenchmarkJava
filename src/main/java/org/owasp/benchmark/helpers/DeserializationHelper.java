package org.owasp.benchmark.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class DeserializationHelper {

    public static void outputDeserializationResults(Object obj, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String resultString = obj.toString();

        out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");
        out.write(
                "The deserialization result is: "
                        + org.owasp.esapi.ESAPI.encoder().encodeForHTML(resultString)
                        + "<br>\n");
        out.write("</p>\n</body>\n</html>");
    }
}
