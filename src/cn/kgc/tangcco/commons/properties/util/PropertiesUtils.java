package cn.kgc.tangcco.commons.properties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	private static PropertiesUtils propertiesUtils = null;
	private Properties properties;
	private Properties propertiesDruid;
	private String path;
	
	private PropertiesUtils(String path) {
		this.path = path;
		this.properties = new Properties();
		this.propertiesDruid = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
		InputStream inDruid = this.getClass().getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(in);
			propertiesDruid.load(inDruid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Properties getProperties() {
		return this.properties;
	}
	public Properties getPropertiesDruid() {
		return this.propertiesDruid;
	}
	public String getValue(String key) {
		return this.properties.getProperty(key);
	}
	public static PropertiesUtils getInstance(String path) {
		
		if(propertiesUtils==null) {
			propertiesUtils = new PropertiesUtils(path);
		}
		return propertiesUtils;
	}
	
}
