package cn.kgc.tangcco.user.dao.impl;

import cn.kgc.tangcco.commons.base.dao.BaseDao;
import cn.kgc.tangcco.user.dao.UserDao;
import cn.kgc.tangcco.user.entity.Tbuser;

public class UserDaoImpl extends BaseDao implements UserDao  {

	@Override
	public void sayHello() {
		System.out.println("dao say hello");
	}

	@Override
	public Tbuser login(Tbuser user) {
		return this.selectOne("select * from tbuser where username=? and password=?", Tbuser.class, user.getUsername(),user.getPassword());
		
	}

}
