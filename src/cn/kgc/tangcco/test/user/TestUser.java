package cn.kgc.tangcco.test.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cn.kgc.tangcco.commons.properties.factory.PropertiesFactory;
import cn.kgc.tangcco.commons.utils.ContextUtils;
import cn.kgc.tangcco.user.dao.UserDao;
import cn.kgc.tangcco.user.entity.Tbuser;
import cn.kgc.tangcco.user.service.UserService;

public class TestUser {

	private UserDao userDao;
	private UserService userService;
	@Before
	public void init() {
		this.userDao = PropertiesFactory.getInstance(ContextUtils.USER.getDao());
//		this.userService = PropertiesFactory.getInstance(ContextUtils.USER.getService());
				
	}
	@Test
	public void testLogin() {
		Tbuser user = new Tbuser();
		user.setUsername("admin");
		user.setPassword("1234");
		System.out.println(userDao.login(user));
	}
	@Test
	public void testUserDao() {
		userDao.sayHello();
	}
	@Test
	public void testUserService() {
		this.userService.sayHello();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
