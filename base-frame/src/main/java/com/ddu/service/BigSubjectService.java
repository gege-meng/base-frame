package com.ddu.service;

import com.ddu.base.BaseService;
import com.ddu.entity.BigSubject;

public interface BigSubjectService extends BaseService<BigSubject>{

	/**
	 * 开始作答
	 * @param id
	 */
	public void startAnswer(Long id);
	
	/**
	 * 结束作答
	 * @param id
	 */
	public void endAnswer(Long id);
	
}
