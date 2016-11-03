package com.feelbat.vo;

import java.io.Serializable;

public class BaseVo implements Serializable,Comparable<BaseVo> {
	private static final long serialVersionUID = 1L;
	
	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public BaseVo() {
		super();
	}
	public BaseVo(long id) {
		super();
		this.id = id;
	}
	@Override
	public int compareTo(BaseVo vo) {
		if(vo != null){
			if(this.id > vo.getId()){
				return 1;
			}else if(this.id == vo.getId()){
				return 0;
			}
		}
		return -1;
	}

	
}
