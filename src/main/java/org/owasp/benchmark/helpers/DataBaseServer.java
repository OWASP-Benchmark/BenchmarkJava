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
 * @author Juan Gama and modified by nesterXneo
 * @created 2015
 */
package org.owasp.benchmark.helpers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import org.owasp.benchmark.service.pojo.Person;
import org.owasp.benchmark.service.pojo.XMLMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DataBaseServer {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseServer.class);
    private static final String NOT_IMPLEMENTED = "Not Implemented.";

    @Autowired
    private DatabaseService databaseService;

    @GetMapping(value = "/resetdb")
    public ResponseEntity<List<XMLMessage>> resetDatabase(@RequestBody Person model) {
        List<XMLMessage> resp = new ArrayList<>();
        resp.add(new XMLMessage(NOT_IMPLEMENTED));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping(value = "/testdb")
    public ResponseEntity<List<XMLMessage>> testDatabase(@RequestBody Person model) {
        List<XMLMessage> resp = new ArrayList<>();
        resp.add(new XMLMessage(NOT_IMPLEMENTED));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<XMLMessage>> getAll() {
        List<XMLMessage> resp = new ArrayList<>();
        String sql = "SELECT * from USERS";
        
        try (Connection connection = databaseService.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                // Process each row and add to resp
                // This is a placeholder - adjust according to your actual data structure
                resp.add(new XMLMessage(resultSet.getString("username")));
            }
            
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (SQLException e) {
            logger.error("Database error occurred", e);
            resp.add(new XMLMessage("An error occurred while processing your request."));
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
