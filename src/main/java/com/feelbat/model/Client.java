package com.feelbat.model;

import java.util.Map;

/**
 * 在线用户对象
 * 
 * @author JueYue
 * @date 2013-9-28
 * @version 1.0
 */
public class Client implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	/**
	 * 用户IP
	 */
	private java.lang.String ip;
	/**
	 *登录时间
	 */
	private java.util.Date logindatetime;


	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.util.Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(java.util.Date logindatetime) {
		this.logindatetime = logindatetime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
