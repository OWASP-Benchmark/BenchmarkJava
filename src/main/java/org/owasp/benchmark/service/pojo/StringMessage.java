package org.owasp.benchmark.service.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class StringMessage {
	private String key;
	private String msg;
	
	public StringMessage(){}
	
	public StringMessage(String key, String msg){
		this.key = key;
		this.msg = msg;
	}
	
	public String getKey() {
		return key;
	}

	@XmlElement
	public void setKey(String key) {
		this.key = key;
	}

	public String getMsg() {
		return msg;
	}

	@XmlElement
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
