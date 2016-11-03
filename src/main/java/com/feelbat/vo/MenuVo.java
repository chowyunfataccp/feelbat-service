package com.feelbat.vo;

import java.io.Serializable;
import java.util.List;

public class MenuVo implements Serializable, Comparable<MenuVo> {

	Long menuid;
	Long groupid;
	String name;
	String url;
	Integer order;
	boolean bareflag;
	boolean topflag;
	
	
	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public boolean isBareflag() {
		return bareflag;
	}

	public void setBareflag(boolean bareflag) {
		this.bareflag = bareflag;
	}

	public boolean isTopflag() {
		return topflag;
	}

	public void setTopflag(boolean topflag) {
		this.topflag = topflag;
	}

	List<MenuVo> subMenuList;
	
	@Override
	public int compareTo(MenuVo arg0) {
		if(this.order != null && arg0.order != null){
			if(this.order.intValue() > arg0.order.intValue()){
				return 1;
			}else if (this.order.intValue() < arg0.order.intValue()){
				return -1;
			}
		}
		return 0;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<MenuVo> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuVo> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
	

}
