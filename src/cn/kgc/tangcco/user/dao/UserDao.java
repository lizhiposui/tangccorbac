package cn.kgc.tangcco.user.dao;

import cn.kgc.tangcco.user.entity.Tbuser;

public interface UserDao {

	void sayHello();
	Tbuser login(Tbuser user);
}
