package com.feelbat.service;

import com.feelbat.entity.MerchantEntity;
import com.feelbat.vo.MerchantVo;

public interface IMerchantService extends IBaseService<MerchantEntity>{
	void fitCurrentSceneid();
	void addMerchant(MerchantVo vo);
	void asyncCreateQrcode(MerchantVo vo);
	MerchantVo getBySceneid(String sceneid);
}
