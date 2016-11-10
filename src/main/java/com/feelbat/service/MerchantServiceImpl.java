package com.feelbat.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feelbat.dao.IBaseDao;
import com.feelbat.dao.IMerchantDao;
import com.feelbat.entity.MerchantEntity;
import com.feelbat.model.CacheManager;
import com.feelbat.vo.MerchantVo;

@Service("merchantService")
@Transactional(rollbackFor=Exception.class)
public class MerchantServiceImpl extends BaseServiceImpl<MerchantEntity> implements IMerchantService {
	
	@Resource(name = "merchantDao")
	@Override
	public void setBaseDao(IBaseDao<MerchantEntity> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	@Autowired
	private IMerchantDao merchantDao;
	
	@Override
	public MerchantVo getBySceneid(String sceneid) {
		String hql = "from MerchantEntity t where t.sceneid=?";
		MerchantEntity bo = merchantDao.get(hql,new Object[]{sceneid});
		MerchantVo vo = null;
		if(bo != null){
			vo = new MerchantVo();
			if(bo.getGroup() != null){
				vo.setGroupid(bo.getGroup().getGid());
			}
			vo.setMerchantid(bo.getMerchantid());
			vo.setName(bo.getName());
			vo.setSceneid(bo.getSceneid());
			vo.setTicket(bo.getTicket());
			if(bo.getUser() != null){
				vo.setUserid(bo.getUser().getUid());
			}
		}
		return vo;
	}
	
	@Override
	public void fitCurrentSceneid() {
		String hql = "from MerchantEntity t where t.sceneid=(select max(sceneid) from MerchantEntity)";
		MerchantEntity bo = merchantDao.get(hql,new Object[]{});
		if(bo != null && bo.getSceneid() != null){
			CacheManager.getInstance().setCurrentSceneid(bo.getSceneid().intValue());
		}
	}
	
	@Override
	public void addMerchant(MerchantVo vo) {
		MerchantEntity bo = new MerchantEntity();
		bo.setName(vo.getName());
		CacheManager.getInstance().plusCurrentSceneid();
		int sceneid = CacheManager.getInstance().getCurrentSceneid();
		bo.setSceneid(sceneid);
		merchantDao.save(bo);
	}
	
	@Async
	@Override
	public void asyncCreateQrcode(MerchantVo vo) {
		MerchantEntity bo = merchantDao.get(MerchantEntity.class,vo.getMerchantid());
		bo.setTicket("ticket");
		merchantDao.update(bo);
	}
	
}
