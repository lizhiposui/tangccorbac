package cn.kgc.tangcco.commons.utils;

import lombok.Getter;

public enum ContextUtils {

	USER("userDao","userService");
	
	private ContextUtils(String dao,String service) {
		this.dao = dao;
		this.service = service;
	}
	@Getter
	private String dao,service;
	
	
	
}
