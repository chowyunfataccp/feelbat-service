package com.feelbat.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feelbat.entity.MenuEntity;
import com.feelbat.vo.MenuVo;


/**
 * 缓存
 * @author JueYue
 * @date 2013-9-28
 * @version 1.0
 */
public class CacheManager {
	
	private static CacheManager instance = new CacheManager();
	
	private CacheManager(){
		
	}
	
	public static CacheManager getInstance(){
		return instance;
	}
	
	private List<MenuVo> menuList = null;
	
	//裸公众号菜单
	private List<MenuVo> bareMenuList = null;
	
	//所有自定义菜单（key:groupid,value:一级菜单）
	private Map<Long,List<MenuVo>> topMenuList = null;

	public List<MenuVo> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuVo> menuList) {
		this.menuList = menuList;
	}

	public List<MenuVo> getBareMenuList() {
		if(menuList != null){
			for(MenuVo menu:menuList){
				if(menu.isBareflag()){
					if(bareMenuList == null){
						bareMenuList = new ArrayList<MenuVo>();
					}
					bareMenuList.add(menu);
				}
			}
		}
		return bareMenuList;
	}

	public Map<Long, List<MenuVo>> getTopMenuList() {
		if(menuList != null){
			for(MenuVo menu:menuList){
				if(menu.isBareflag()){
					if(topMenuList == null){
						topMenuList = new HashMap<Long, List<MenuVo>>();
					}
					Long groupid = menu.getGroupid();
					List<MenuVo> subMenuList = menu.getSubMenuList();
					topMenuList.put(groupid, subMenuList);
				}
			}
		}
		return topMenuList;
	}
	
	

}