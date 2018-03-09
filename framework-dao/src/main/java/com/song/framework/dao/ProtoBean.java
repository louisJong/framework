package com.song.framework.dao;

import java.util.Date;

public class ProtoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3563368275262474606L;
	
	private Long id;
	private Date createTime;
	private Date updateTime;
	private Integer version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}