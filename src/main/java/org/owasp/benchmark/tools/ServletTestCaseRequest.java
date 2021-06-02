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
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

/*
 * This class is used by the crawlers to test the target Benchmark style web application. It tests Servlet style
 * web applications that use traditional GET parameters in URLs, POST body parameters, header name/values, cookies,
 * etc. Nothing fancy, specific to particular frameworks, like parameters embedded in the URL path, etc.
 */

public class ServletTestCaseRequest extends AbstractTestCaseRequest {

    public ServletTestCaseRequest(
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

    @SuppressWarnings("deprecation")
    @Override
    void buildQueryString() {
        setQuery("");
        boolean first = true;
        for (NameValuePair field : getGetParams()) {
            if (first) {
                setQuery("?");
                first = false;
            } else {
                setQuery(getQuery() + "&");
            }
            String name = field.getName();
            String value = field.getValue();
            // System.out.println(query);
            setQuery(getQuery() + (name + "=" + URLEncoder.encode(value)));
        }
    }

    @Override
    HttpRequestBase createRequestInstance(String URL) {
        // If there are query parameters, this must be a GET, otherwise a POST.
        if (getQuery().length() == 0) {
            return new HttpPost(URL);
        } else {
            return new HttpGet(URL);
        }
    }

    @Override
    void buildHeaders(HttpRequestBase request) {
        for (NameValuePair header : getHeaders()) {
            String name = header.getName();
            String value = header.getValue();
            // System.out.println("Header:" + name + "=" + value);
            request.addHeader(name, value);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    void buildCookies(HttpRequestBase request) {
        for (NameValuePair cookie : getCookies()) {
            String name = cookie.getName();
            String value = cookie.getValue();
            // Note: URL encoding of a space becomes a +, which is OK for Java, but
            // not other languages. So after URLEncoding, replace all + with %20, which is the
            // standard URL encoding for a space char.
            request.addHeader("Cookie", name + "=" + URLEncoder.encode(value).replace("+", "%20"));
        }
    }

    @Override
    void buildBodyParameters(HttpRequestBase request) {
        List<NameValuePair> fields = getFormParams();

        // Add the body parameters to the request if there were any
        if (fields.size() > 0) {
            try {
                ((HttpEntityEnclosingRequestBase) request)
                        .setEntity(new UrlEncodedFormEntity(fields));
            } catch (UnsupportedEncodingException e) {
                System.out.println("Error encoding URL." + e.getMessage());
            }
        }
    }
}
