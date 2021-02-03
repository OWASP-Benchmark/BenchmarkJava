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
* @created 2015
*/

package org.owasp.benchmark.helpers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.benchmark.service.pojo.Person;
import org.owasp.benchmark.service.pojo.StringMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBaseServer {

	@RequestMapping(value = "/resetdb", method = RequestMethod.GET)
	public ResponseEntity<List<StringMessage>> getOtherOrder(@RequestBody Person model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StringMessage> resp = new ArrayList<StringMessage>();
		resp.add(new StringMessage("Message", "Not Implemented."));
		return new ResponseEntity<List<StringMessage>>(resp, HttpStatus.OK);
	}

	@RequestMapping(value = "/testdb", method = RequestMethod.POST)
	public ResponseEntity<List<StringMessage>> createOrder2(@RequestBody Person model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<StringMessage> resp = new ArrayList<StringMessage>();
		resp.add(new StringMessage("Message", "Not Implemented."));
		return new ResponseEntity<List<StringMessage>>(resp, HttpStatus.OK);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<StringMessage>> getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<StringMessage> resp = new ArrayList<StringMessage>();
		String sql = "SELECT * from USERS";
		try {
			java.sql.Connection connection = org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, resp);
		} catch (java.sql.SQLException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
				e.printStackTrace();
				resp.add(new StringMessage("Message", "Error processing request: " + e.getMessage()));
				return new ResponseEntity<List<StringMessage>>(resp, HttpStatus.OK);
			} else
				throw new ServletException(e);
		}
		return new ResponseEntity<List<StringMessage>>(resp, HttpStatus.OK);
	}

	public static void main(String[] args) throws ServletException, IOException, NamingException, SQLException {

	}

}