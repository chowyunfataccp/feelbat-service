package com.feelbat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feelbat.dao.IBaseDao;
import com.feelbat.dao.IMenuDao;
import com.feelbat.entity.MenuEntity;
import com.feelbat.model.CacheManager;
import com.feelbat.vo.MenuVo;

@Service("menuService")
@Transactional(rollbackFor=Exception.class)
public class MenuServiceImpl extends BaseServiceImpl<MenuEntity> implements IMenuService {
	
	@Resource(name = "menuDao")
	@Override
	public void setBaseDao(IBaseDao<MenuEntity> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	@Autowired
	private IMenuDao menuDao;
	
	@Override
	public void loadAll() {
		String hql = "from MenuEntity t where t.top=?";
		List<MenuEntity> listBo = menuDao.find(hql,Integer.valueOf(1));
		List<MenuVo> listVo = new ArrayList<MenuVo>();
		for(MenuEntity bo:listBo){
			MenuVo vo = new MenuVo();
			vo.setMenuid(bo.getMenuid());
			vo.setName(bo.getName());
			vo.setUrl(bo.getUrl());
			vo.setOrder(bo.getOrder());
			if(bo.getGroup() == null){
				vo.setBareflag(true);
			}else{
				vo.setGroupid(bo.getGroup().getGid());
			}
			vo.setTopflag(true);
			if(bo.getSubmenu() != null && !bo.getSubmenu().isEmpty()){
				List<MenuVo> subList = new ArrayList<MenuVo>();
				for(MenuEntity subBo:bo.getSubmenu()){
					MenuVo subVo = new MenuVo();
					subVo.setMenuid(subBo.getMenuid());
					subVo.setName(subBo.getName());
					subVo.setUrl(subBo.getUrl());
					subVo.setOrder(subBo.getOrder());
					subVo.setTopflag(false);
					subList.add(subVo);
				}
				Collections.sort(subList);
				vo.setSubMenuList(subList);
			}
			listVo.add(vo);
		}
		Collections.sort(listVo);
		CacheManager.getInstance().setMenuList(listVo);
	}
	
}
