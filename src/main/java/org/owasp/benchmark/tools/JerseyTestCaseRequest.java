/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details
 *
 * @author Juan Gama
 * @created 2017
 */
package org.owasp.benchmark.tools;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

public class JerseyTestCaseRequest extends AbstractTestCaseRequest {

    public JerseyTestCaseRequest(
            String fullURL,
            TestCaseType tcType,
            String category,
            String payload,
            String name,
            String uiTemplateFile,
            String templateFile,
            String sourceFile,
            String sourceUIType,
            String dataflowFile,
            String sinkFile,
            boolean isVulnerability,
            String attackSuccessString,
            List<NameValuePair> headers,
            List<NameValuePair> cookies,
            List<NameValuePair> getParams,
            List<NameValuePair> formParams) {
        super(
                fullURL,
                tcType,
                category,
                payload,
                name,
                uiTemplateFile,
                templateFile,
                sourceFile,
                sourceUIType,
                dataflowFile,
                sinkFile,
                isVulnerability,
                attackSuccessString,
                headers,
                cookies,
                getParams,
                formParams);
    }

    @Override
    void buildQueryString() {
        setQuery("");
    }

    @Override
    HttpRequestBase createRequestInstance(String URL) {
        // Apparently all Jersey Requests are POSTS. Never any query string params per buildQuery()
        // above.
        HttpPost httpPost = new HttpPost(URL);
        return httpPost;
    }

    @Override
    void buildHeaders(HttpRequestBase request) {
        request.addHeader("Content-Type", "application/xml; charset=utf-8");
        for (NameValuePair header : getHeaders()) {
            String name = header.getName();
            String value = header.getValue();
            // System.out.println("Header:" + name + "=" + value);
            request.addHeader(name, value);
        }
    }

    @Override
    void buildCookies(HttpRequestBase request) {
        for (NameValuePair cookie : getCookies()) {
            String name = cookie.getName();
            String value = cookie.getValue();
            // System.out.println("Cookie:" + name + "=" + value);
            request.addHeader("Cookie", name + "=" + value);
        }
    }

    @Override
    void buildBodyParameters(HttpRequestBase request) {
        String params = "<person>";
        for (NameValuePair field : getFormParams()) {
            String name = field.getName();
            String value = field.getValue();
            params += "<" + name + ">" + escapeXML(value) + "</" + name + ">";
        }
        params += "</person>";
        try {
            StringEntity paramsEnt = new StringEntity(params);
            ((HttpEntityEnclosingRequestBase) request).setEntity(paramsEnt);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error encoding URL." + e.getMessage());
        }
    }

    private static String escapeXML(String value) {
        value = value.replace("&", "&amp;");
        value = value.replace("\"", "&quot;");
        value = value.replace("'", "&apos;");
        value = value.replace("<", "&lt;");
        value = value.replace(">", "&gt;");

        return value;
    }
}
