package com.feelbat.service;

import java.util.List;

import com.feelbat.entity.MenuEntity;

public interface IMenuService extends IBaseService<MenuEntity>{
	void loadAll();
}
