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
    private String id;

    private String name;

    private int cwe;

    private boolean isInjection;

    /**
     * Create a vuln category.
     *
     * @param id The short name for the category, e.g., xss.
     * @param name The long name of the category, e.g., Cross Site Scripting
     * @param cwe The associated CWE number.
     * @param isInjection Whether this vuln category is a type of injection attack.
     */
    public Category(String id, String name, int cwe, boolean isInjection) {
        this.id = id;
        this.name = name;
        this.cwe = cwe;
        this.isInjection = isInjection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCwe() {
        return cwe;
    }

    public void setCwe(int cwe) {
        this.cwe = cwe;
    }

    public boolean isInjection() {
        return isInjection;
    }

    public void setInjection(boolean isInjection) {
        this.isInjection = isInjection;
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
