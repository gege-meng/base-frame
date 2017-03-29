package com.ddu.base;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected abstract BaseMapper<T> getMapper();

	@Override
	public Long insert(T entity) {
		return getMapper().insert(entity);
	}

	@Override
	public void delete(Long id) {
		getMapper().delete(id);
	}

	@Override
	public void update(T entity) {
		getMapper().update(entity);
	}

	@Override
	public List<T> queryAll() {
		return getMapper().queryAll();
	}

	@Override
	public List<T> queryAllByEntity(T entity) {
		return getMapper().queryAllByEntity(entity);
	}

	@Override
	public T queryOne(Long id) {
		return getMapper().queryOne(id);
	}

}