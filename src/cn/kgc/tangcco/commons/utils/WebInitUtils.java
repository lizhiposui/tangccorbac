package cn.kgc.tangcco.commons.utils;

import lombok.Getter;

public enum WebInitUtils {

	PREFIX("/WEB-INF/jsp/"),SUFFIX(".jsp"),
	METHODNAME("methodName"),JSON("json"),
	DOADD("doAdd"),DOUPDATE("doUpdate"),DODELETE("doDelete");
	
	private WebInitUtils(String param) {
		this.param = param;
	}
	@Getter
	private String param;
	
}
