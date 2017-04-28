package org.owasp.benchmark.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Node;

public class ServletTestCaseRequest extends AbstractTestCaseRequest {

	public ServletTestCaseRequest(String name, String fullURL, String tcType, List<Node> headers, List<Node> cookies,
			List<Node> getParams, List<Node> formParams, String payload) {
		super(name, fullURL, tcType, headers, cookies, getParams, formParams, payload);
	}

	@SuppressWarnings("deprecation")
	@Override
	void buildQueryString() {
		setQuery("");
		boolean first = true;
		for (Node field : getGetParams()) {
			if (first) {
				setQuery("?");
				first = false;
			} else {
				setQuery(getQuery() + "&");
			}
			String name = XMLCrawler.getAttributeValue("name", field);
			String value = XMLCrawler.getAttributeValue("value", field);
			// System.out.println(query);
			setQuery(getQuery() + (name + "=" + URLEncoder.encode(value)));
		}
	}

	@Override
	HttpRequestBase createRequestInstance(String URL) {
		HttpPost httpPost = new HttpPost(URL);
		return httpPost;
	}

	@Override
	void buildHeaders(HttpRequestBase request) {
		for (Node header : getHeaders()) {
			String name = XMLCrawler.getAttributeValue("name", header);
			String value = XMLCrawler.getAttributeValue("value", header);
			// System.out.println("Header:" + name + "=" + value);
			request.addHeader(name, value);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	void buildCookies(HttpRequestBase request) {
		for (Node cookie : getCookies()) {
			String name = XMLCrawler.getAttributeValue("name", cookie);
			String value = XMLCrawler.getAttributeValue("value", cookie);
			request.addHeader("Cookie", name + "=" + URLEncoder.encode(value));
		}
	}

	@Override
	void buildBodyParameters(HttpRequestBase request) {
		List<NameValuePair> fields = new ArrayList<NameValuePair>();
		for (Node field : getFormParams()) {
			String name = XMLCrawler.getAttributeValue("name", field);
			String value = XMLCrawler.getAttributeValue("value", field);
			// System.out.println(name+"="+value);
			NameValuePair nvp = new BasicNameValuePair(name, value);
			fields.add(nvp);
		}
		try {
			((HttpEntityEnclosingRequestBase) request).setEntity(new UrlEncodedFormEntity(fields));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error encoding URL." + e.getMessage());
		}

	}

}
