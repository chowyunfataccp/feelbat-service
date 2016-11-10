package com.feelbat.vo;

import java.io.Serializable;

public class MerchantVo implements Serializable {

	private Long merchantid;
	
	private String name;
	
	private Integer sceneid;
	
	private String ticket;
	
	private Long userid;
	
	private Long groupid;

	public Long getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(Long merchantid) {
		this.merchantid = merchantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSceneid() {
		return sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}
	
	
	
}
