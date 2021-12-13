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
package org.owasp.benchmark.service.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {

    private long id;
    private String address;
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(long id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person [id="
                + id
                + ", address="
                + address
                + ", firstName="
                + firstName
                + ", lastName="
                + lastName
                + "]";
    }
}
