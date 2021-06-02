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
        JERSEYWS,
        SERVLET,
        SPRINGWS,
        NODEEXPRESS
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

    private String category;
    private List<NameValuePair> cookies;
    private String dataflowFile;
    private List<NameValuePair> formParams;
    private String fullURL;
    private List<NameValuePair> getParams;
    private List<NameValuePair> headers;
    private boolean isPassed;
    private boolean isVulnerability;
    private String attackSuccessString;
    private String name;
    private String payload;

    private String query;
    private String sinkFile;
    private String sourceFile;
    private String sourceUIType;
    private TestCaseType tcType;
    private String templateFile;

    private String uiTemplateFile;

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
            String attackSuccessString,
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
        this.attackSuccessString = attackSuccessString;
        this.headers = headers;
        this.cookies = cookies;
        this.getParams = getParams;
        this.formParams = formParams;
    }

    /** Defines what parameters in the body will be sent. */
    abstract void buildBodyParameters(HttpRequestBase request);

    /** Defines what cookies will be sent. */
    abstract void buildCookies(HttpRequestBase request);

    /** Defines what headers will be sent. */
    abstract void buildHeaders(HttpRequestBase request);

    /** Defines how to construct URL query string. */
    abstract void buildQueryString();

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

    public String getAttackSuccessString() {
        return attackSuccessString;
    }

    public String getCategory() {
        return category;
    }

    public List<NameValuePair> getCookies() {
        return cookies;
    }

    public String getDataflowFile() {
        return dataflowFile;
    }

    public List<NameValuePair> getFormParams() {
        return formParams;
    }

    public String getFullURL() {
        return fullURL;
    }

    public List<NameValuePair> getGetParams() {
        return getParams;
    }

    public List<NameValuePair> getHeaders() {
        return headers;
    }

    public String getName() {
        return name;
    }

    public String getPayload() {
        return payload;
    }

    public String getQuery() {
        return query;
    }

    public String getSinkFile() {
        return sinkFile;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public String getSourceUIType() {
        return sourceUIType;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public TestCaseType getType() {
        return tcType;
    }

    public String getUiTemplateFile() {
        return uiTemplateFile;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public boolean isVulnerability() {
        return isVulnerability;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCookies(List<NameValuePair> cookies) {
        this.cookies = cookies;
    }

    public void setDataflowFile(String dataflowFile) {
        this.dataflowFile = dataflowFile;
    }

    public void setFormParams(List<NameValuePair> formParams) {
        this.formParams = formParams;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public void setGetParams(List<NameValuePair> getParams) {
        this.getParams = getParams;
    }

    public void setHeaders(List<NameValuePair> headers) {
        this.headers = headers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setSinkFile(String sinkFile) {
        this.sinkFile = sinkFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void setSourceUIType(String sourceUIType) {
        this.sourceUIType = sourceUIType;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public void setType(TestCaseType type) {
        this.tcType = type;
    }

    public void setUiTemplateFile(String uiTemplateFile) {
        this.uiTemplateFile = uiTemplateFile;
    }

    public void setVulnerability(boolean isVulnerability) {
        this.isVulnerability = isVulnerability;
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
}
