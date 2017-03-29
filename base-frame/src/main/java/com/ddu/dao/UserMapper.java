package com.ddu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ddu.base.BaseMapper;
import com.ddu.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User>{
	
	public User queryByNameAndNumber(@Param("number") String number, @Param("name") String name);
	
}
	