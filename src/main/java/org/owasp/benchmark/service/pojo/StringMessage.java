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
