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
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.helpers;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ThingFactory {
	
	public static ThingInterface createThing() {
		
		Properties props = new Properties();

		// create a thing using reflection
		try (InputStream thingproperties = ThingFactory.class.getClassLoader().getResourceAsStream("thing.properties")) {
			if (thingproperties == null) {
				System.out.println("Can't find thing.properties");
				return new Thing2();
			}
			props.load(thingproperties);
			String which = "org.owasp.benchmark.helpers." + props.getProperty("thing");
			
			Class<?> thing = Class.forName(which);
			Constructor<?> thingConstructor = thing.getConstructor();
			Object thingInstance = thingConstructor.newInstance();
			
			return (ThingInterface)thingInstance;
			
		} catch (Exception e) {
			System.out.println("Error constructing Thing.");			
			e.printStackTrace();
			return new Thing1();
		}
	}

}
