package com.ddu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.ddu.entity.User;
import com.ddu.service.UserService;

public class BaseController {

	@Resource
	protected UserService userService;
	
	protected User getCurrentUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		if(StringUtils.isBlank(userId))
			return null;
		
		return userService.queryOne(Long.valueOf(userId));
	}
	
}
