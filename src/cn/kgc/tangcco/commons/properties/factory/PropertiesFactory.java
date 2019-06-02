package cn.kgc.tangcco.commons.properties.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.kgc.tangcco.commons.properties.util.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PropertiesFactory {

	private static Map<String, Object> map = new ConcurrentHashMap<>();
	
	public static <T>T getInstance(String key){
		T object = null;
		if(map.containsKey(key)) {
			return (T) map.get(key);
		}else {
			try {
				Class<?> clazz = Class.forName(PropertiesUtils.getInstance("applicationContext.properties").getValue(key));
				object = (T) clazz.newInstance();
				map.put(key, object);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				log.error("对不起，初始化对象失败");
			}
		}
		
		return object;
	}
}
