package com.ddu.service;

import com.ddu.base.BaseService;
import com.ddu.entity.User;

public interface UserService extends BaseService<User>{

	public User queryByNameAndNumber(String number, String name);
	
}
