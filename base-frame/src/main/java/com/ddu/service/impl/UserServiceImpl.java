package com.ddu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ddu.base.BaseServiceImpl;
import com.ddu.base.BaseMapper;
import com.ddu.dao.UserMapper;
import com.ddu.entity.User;
import com.ddu.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource
	private UserMapper mapper;
	
	@Override
	protected BaseMapper<User> getMapper() {
		return mapper;
	}

	@Override
	public User queryByNameAndNumber(String number, String name) {
		return mapper.queryByNameAndNumber(number, name);
	}

}
