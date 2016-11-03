package com.feelbat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.feelbat.dao.IBaseDao;
import com.feelbat.dao.PageList;


@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public  class BaseServiceImpl<T> implements IBaseService<T>{

	IBaseDao<T> baseDao;
	
	public IBaseDao<T> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	public java.io.Serializable save(T o) {
		return baseDao.save(o);
	}
	
	public void delete(T o) {
		baseDao.delete(o);
	}
	
	public void update(T o) {
		baseDao.update(o);
	}
	
	public void saveOrUpdate(T o) {
		baseDao.saveOrUpdate(o);
	}
	
	@Override
	public T get(Class<T> cls,Serializable id) {
		return baseDao.get(cls,id);
	}
	
	@Override
	public T get(String hql, Object... param) {
		return baseDao.get(hql, param);
	}
	
	@Override
	public List<T> findAll(Class<T> cls) {
		return baseDao.findAll(cls);
	}
	
	@Override
	public List<T> find(String hql) {
		return baseDao.find(hql);
	}
	
	@Override
	public List<T> find(String hql, Object... param) {
		return baseDao.find(hql, param);
	}
	
	@Override
	public int executeHql(String hql) {
		return baseDao.executeHql(hql);
	}
	
	@Override
	public int executeHql(String hql, Object... param) {
		return baseDao.executeHql(hql, param);
	}
	
	@Override
	public int count(String hql) {
		return baseDao.count(hql);
	}
	
	@Override
	public int count(String hql, Object... param) {
		return baseDao.count(hql, param);
	}
	
	@Override
	public PageList<T> findPageList(String hql, int page, int rows) {
		return baseDao.findPageList(hql, page, rows);
	}
	
	@Override
	public PageList<T> findPageList(String hql, int page, int rows,
			Object... objects) {
		return baseDao.findPageList(hql, page, rows, objects);
	}
}
