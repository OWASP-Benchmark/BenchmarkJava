/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https:/owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * @author David Anderson
 * @created 2021
 */
package org.owasp.benchmark.helpers;

/** This class contains a single vulnerability category. */
public class Category {

    private final String id; // e.g., pathtraver
    private final String name; // e.g., Path Traversal
    private final int CWE;
    private final boolean isInjection;
    private final String shortName; // PATH

    /**
     * Create a vuln category.
     *
     * @param id The short name for the category, e.g., xss.
     * @param name The long name of the category, e.g., Cross Site Scripting
     * @param cwe The associated CWE number.
     * @param isInjection Whether this vuln category is a type of injection attack.
     */
    public Category(String id, String name, int cwe, boolean isInjection, String shortname) {
        this.id = id;
        this.name = name;
        this.CWE = cwe;
        this.isInjection = isInjection;
        this.shortName = shortname;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getCWE() {
        return this.CWE;
    }

    public boolean isInjection() {
        return this.isInjection;
    }

    public String getShortName() {
        return this.shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Category)) return false;
        Category other = (Category) o;
        return (this.id == null && other.id == null)
                || (this.id != null && this.id.equals(other.id));
    }
}
