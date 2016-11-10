package com.feelbat.listener;


import org.springframework.beans.factory.InitializingBean;

import com.feelbat.service.IMenuService;
import com.feelbat.service.IMerchantService;
import com.feelbat.util.ApplicationContextUtil;

public class InitDataListener implements InitializingBean {

	private IMenuService menuService;
	
	private IMerchantService merchantService;
	

	public void afterPropertiesSet() throws Exception {
		menuService = (IMenuService)ApplicationContextUtil.getBean("menuService");
		menuService.loadAll();
		
		merchantService = (IMerchantService)ApplicationContextUtil.getBean("merchantService");
		merchantService.fitCurrentSceneid();
	}
	

}
