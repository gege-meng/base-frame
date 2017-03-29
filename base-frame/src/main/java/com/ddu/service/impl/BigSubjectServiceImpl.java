package com.ddu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ddu.base.BaseMapper;
import com.ddu.base.BaseServiceImpl;
import com.ddu.dao.BigSubjectMapper;
import com.ddu.entity.BigSubject;
import com.ddu.enums.SubjectStateEnum;
import com.ddu.service.BigSubjectService;

@Service("bigSubjectService")
public class BigSubjectServiceImpl extends BaseServiceImpl<BigSubject> implements BigSubjectService{

	@Resource
	private BigSubjectMapper mapper;
	
	@Override
	protected BaseMapper<BigSubject> getMapper() {
		return mapper;
	}

	@Override
	public void startAnswer(Long id) {
		mapper.updateStateById(id, SubjectStateEnum.Answering.getValue());
	}

	@Override
	public void endAnswer(Long id) {
		mapper.updateStateById(id, SubjectStateEnum.Answered.getValue());
	}
	
}
