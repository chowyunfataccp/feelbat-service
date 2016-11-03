/*package com.feelbat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feelbat.dao.IBaseDao;
import com.feelbat.entity.GroupEntity;
import com.feelbat.entity.UserEntity;

@Service("groupService")
@Transactional(rollbackFor=Exception.class)
public class GroupServiceImpl extends BaseServiceImpl<GroupEntity> implements IGroupService {
	
	@Resource(name = "groupDao")
	@Override
	public void setBaseDao(IBaseDao<GroupEntity> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	
}
*/