/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Juan Gama
* @created 2017
*/

package org.owasp.benchmark.tools;

import java.util.List;

import org.apache.http.client.methods.HttpRequestBase;
import org.w3c.dom.Node;

public abstract class AbstractTestCaseRequest {

	private String fullURL;
	private String query;
	private String tcType;
	private String payload;
	private String name;
	private boolean passed;
	private List<Node> headers;
	private List<Node> cookies;
	private List<Node> getParams;
	private List<Node> formParams;

	public AbstractTestCaseRequest(String name, String fullURL, String tcType, List<Node> headers, List<Node> cookies,
			List<Node> getParams, List<Node> formParams, String payload) {
		this.name = name;
		this.fullURL = fullURL;
		this.tcType = tcType;
		this.headers = headers;
		this.cookies = cookies;
		this.getParams = getParams;
		this.formParams = formParams;
		this.payload = payload;
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
	 * Method to create a POST, GET, DELETE, HEAD, OPTIONS, TRACE request
	 * object.
	 * 
	 * @return an instance of a subclass of HttpRequestBase
	 */
	abstract HttpRequestBase createRequestInstance(String URL);

	/**
	 * Defines how to construct URL query string.
	 */
	abstract void buildQueryString();

	/**
	 * Defines what headers will be send.
	 */
	abstract void buildHeaders(HttpRequestBase request);

	/**
	 * Defines what cookies will be send.
	 */
	abstract void buildCookies(HttpRequestBase request);

	/**
	 * Defines what parameter on the body will be send.
	 */
	abstract void buildBodyParameters(HttpRequestBase request);

	public String getFullURL() {
		return fullURL;
	}

	public void setFullURL(String fullURL) {
		this.fullURL = fullURL;
	}

	public String getTcType() {
		return tcType;
	}

	public void setTcType(String tcType) {
		this.tcType = tcType;
	}

	public List<Node> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Node> headers) {
		this.headers = headers;
	}

	public List<Node> getCookies() {
		return cookies;
	}

	public void setCookies(List<Node> cookies) {
		this.cookies = cookies;
	}

	public List<Node> getGetParams() {
		return getParams;
	}

	public void setGetParams(List<Node> getParams) {
		this.getParams = getParams;
	}

	public List<Node> getFormParams() {
		return formParams;
	}

	public void setFormParams(List<Node> formParams) {
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
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AbstractTestCaseRequest [fullURL=" + fullURL + ", query=" + query + ", tcType=" + tcType + ", payload="
				+ payload + ", name=" + name + ", passed=" + passed + ", headers=" + headers + ", cookies=" + cookies
				+ ", getParams=" + getParams + ", formParams=" + formParams + "]";
	}
	
	
}
