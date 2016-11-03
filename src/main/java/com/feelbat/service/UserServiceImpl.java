/*package com.feelbat.service;

import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feelbat.dao.IBaseDao;
import com.feelbat.dao.IGroupDao;
import com.feelbat.entity.GroupEntity;
import com.feelbat.entity.UserEntity;

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements IUserService {
	
	@Resource(name = "userDao")
	@Override
	public void setBaseDao(IBaseDao<UserEntity> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	@Autowired
	private IGroupDao groupDao;
	
	@Override
	public void both() {
		GroupEntity g = groupDao.get(GroupEntity.class,17L);
		UserEntity u = new UserEntity();
		g.getUsers().add(u);
	}
	
}
*/