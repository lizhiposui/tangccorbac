package cn.kgc.tangcco.commons.utils;

import lombok.Getter;

public enum ContextUtils {

	USER("userDao","userService"),
	GRADE("gradeDao","gradeService"),
	STUDENT("studentDao","studentService");
	
	private ContextUtils(String dao,String service) {
		this.dao = dao;
		this.service = service;
	}
	@Getter
	private String dao,service;
	
	
	
}
