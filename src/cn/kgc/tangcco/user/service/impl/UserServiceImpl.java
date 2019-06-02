package cn.kgc.tangcco.user.service.impl;

import cn.kgc.tangcco.commons.properties.factory.PropertiesFactory;
import cn.kgc.tangcco.commons.utils.ContextUtils;
import cn.kgc.tangcco.user.dao.UserDao;
import cn.kgc.tangcco.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public UserServiceImpl() {
		userDao = PropertiesFactory.getInstance(ContextUtils.USER.getDao());
	}
	
	@Override
	public void sayHello() {
		System.out.println("service say hello");
		userDao.sayHello();
	}

}
