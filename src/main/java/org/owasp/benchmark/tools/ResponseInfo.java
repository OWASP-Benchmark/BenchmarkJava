package org.owasp.benchmark.tools;

import org.apache.http.client.methods.HttpRequestBase;

class ResponseInfo {
    private String responseString;
    private double time;
    private int statusCode;
    private HttpRequestBase requestBase;

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpRequestBase getRequestBase() {
        return requestBase;
    }

    public void setRequestBase(HttpRequestBase requestBase) {
        this.requestBase = requestBase;
    }
}
