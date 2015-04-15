package org.owasp.webgoat.benchmark.helpers;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ThingFactory {
	
	public static ThingInterface createThing() {
		
		Properties props = new Properties();

		// create a thing using reflection
		try {
			InputStream thingproperties = ThingFactory.class.getResourceAsStream("thing.properties");
			if (thingproperties == null) {
				System.out.println("Can't find thing.properties");
				return new Thing2();
			}
			props.load(thingproperties);
			String which = "org.owasp.webgoat.benchmark.helpers." + props.getProperty("thing");
			
			Class thing = Class.forName(which);
			Constructor thingConstructor = thing.getConstructor();
			Object thingInstance = thingConstructor.newInstance();
			
			return (ThingInterface)thingInstance;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new Thing1();
		}
	}

}
