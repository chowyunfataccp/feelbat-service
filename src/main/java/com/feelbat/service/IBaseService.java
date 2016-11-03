package com.feelbat.service;

import java.io.Serializable;
import java.util.List;

import com.feelbat.dao.PageList;

public interface IBaseService<T> {
	/**
	 * 保存一个对象
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 删除一个对象
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 更新一个对象
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * 保存或更新对象
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);
	

	/**
	 * 获得一个对象
	 * 
	 * @param c
	 *            对象类型
	 * @param id
	 * @return Object
	 */
	public T get(Class<T> cls,Serializable id);

	/**
	 * 获得一个对象
	 * 
	 * @param hql
	 * @param param
	 * @return Object
	 */
	public T get(String hql, Object... param);
	
	
	/**
	 * 加载所有对象
	 * 
	 * @return
	 */
	public List<T> findAll(Class<T> cls);

	/**
	 * 查询
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object... param);


	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @return 响应数目
	 */
	public int executeHql(String hql);

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @param param
	 * @return 响应数目
	 */
	public int executeHql(String hql, Object... param);
	

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @return
	 */
	public int count(String hql);

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public int count(String hql, Object... param);

	
	PageList<T> findPageList(String hql, int page, int rows);
	
	PageList<T> findPageList(String hql, int page, int rows,Object... objects);
}