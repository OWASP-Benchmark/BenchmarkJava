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

import java.lang.invoke.MethodHandles;
import java.util.Comparator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;

public abstract class AbstractTestCaseRequest {

    /*
     * The 1st three are Java.
     */
    public enum TestCaseType {
        SERVLET,
        SPRINGWS,
        JERSEYWS,
        NODEEXPRESS
    }

    private String fullURL;
    private String query;
    private TestCaseType tcType;
    private String category;
    private String payload;
    private String name;
    private String uiTemplateFile;
    private String templateFile;
    private String sourceFile;
    private String sourceUIType;
    private String dataflowFile;
    private String sinkFile;

    private boolean isPassed;
    private boolean isVulnerability;
    private List<NameValuePair> headers;
    private List<NameValuePair> cookies;
    private List<NameValuePair> getParams;
    private List<NameValuePair> formParams;

    public AbstractTestCaseRequest(
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
            List<NameValuePair> headers,
            List<NameValuePair> cookies,
            List<NameValuePair> getParams,
            List<NameValuePair> formParams) {
        super();
        this.fullURL = fullURL;
        this.tcType = tcType;
        this.category = category;
        this.payload = payload;
        this.name = name;
        this.uiTemplateFile = uiTemplateFile;
        this.templateFile = templateFile;
        this.sourceFile = sourceFile;
        this.sourceUIType = sourceUIType;
        this.dataflowFile = dataflowFile;
        this.sinkFile = sinkFile;
        this.isVulnerability = isVulnerability;
        this.headers = headers;
        this.cookies = cookies;
        this.getParams = getParams;
        this.formParams = formParams;
    }

    public HttpRequestBase buildRequest() {
        buildQueryString();
        HttpRequestBase request = createRequestInstance(fullURL + query);
        buildHeaders(request);
        buildCookies(request);
        buildBodyParameters(request);
        return request;
    }

    /**
     * Method to create a POST, GET, DELETE, HEAD, OPTIONS, TRACE request object.
     *
     * @return an instance of a subclass of HttpRequestBase
     */
    abstract HttpRequestBase createRequestInstance(String URL);

    /** Defines how to construct URL query string. */
    abstract void buildQueryString();

    /** Defines what headers will be send. */
    abstract void buildHeaders(HttpRequestBase request);

    /** Defines what cookies will be send. */
    abstract void buildCookies(HttpRequestBase request);

    /** Defines what parameter on the body will be send. */
    abstract void buildBodyParameters(HttpRequestBase request);

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public TestCaseType getType() {
        return tcType;
    }

    public void setType(TestCaseType type) {
        this.tcType = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<NameValuePair> getHeaders() {
        return headers;
    }

    public void setHeaders(List<NameValuePair> headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getCookies() {
        return cookies;
    }

    public void setCookies(List<NameValuePair> cookies) {
        this.cookies = cookies;
    }

    public List<NameValuePair> getGetParams() {
        return getParams;
    }

    public void setGetParams(List<NameValuePair> getParams) {
        this.getParams = getParams;
    }

    public List<NameValuePair> getFormParams() {
        return formParams;
    }

    public void setFormParams(List<NameValuePair> formParams) {
        this.formParams = formParams;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public boolean isVulnerability() {
        return isVulnerability;
    }

    public void setVulnerability(boolean isVulnerability) {
        this.isVulnerability = isVulnerability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUiTemplateFile() {
        return uiTemplateFile;
    }

    public void setUiTemplateFile(String uiTemplateFile) {
        this.uiTemplateFile = uiTemplateFile;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceUIType() {
        return sourceUIType;
    }

    public void setSourceUIType(String sourceUIType) {
        this.sourceUIType = sourceUIType;
    }

    public String getDataflowFile() {
        return dataflowFile;
    }

    public void setDataflowFile(String dataflowFile) {
        this.dataflowFile = dataflowFile;
    }

    public String getSinkFile() {
        return sinkFile;
    }

    public void setSinkFile(String sinkFile) {
        this.sinkFile = sinkFile;
    }

    @Override
    public String toString() {
        return MethodHandles.lookup().lookupClass().getSimpleName()
                + " [fullURL="
                + fullURL
                + ", query="
                + query
                + ", type="
                + tcType
                + ", category="
                + category
                + ", payload="
                + payload
                + ", name="
                + name
                + ", uiTemplateFile="
                + uiTemplateFile
                + ", templateFile="
                + templateFile
                + ", sourceFile="
                + sourceFile
                + ", sourceUIType="
                + sourceUIType
                + ", dataflowFile="
                + dataflowFile
                + ", sinkFile="
                + sinkFile
                + ", isPassed="
                + isPassed
                + ", isVulnerability="
                + isVulnerability
                + ", headers="
                + headers
                + ", cookies="
                + cookies
                + ", getParams="
                + getParams
                + ", formParams="
                + formParams
                + "]";
    }

    public static Comparator<AbstractTestCaseRequest> getNameComparator() {
        return new Comparator<AbstractTestCaseRequest>() {

            @Override
            public int compare(AbstractTestCaseRequest o1, AbstractTestCaseRequest o2) {
                if (!o1.name.equalsIgnoreCase(o2.name)) return o1.name.compareTo(o2.name);
                return 0;
            }
        };
    }
}
