package maven_ssm.basic.entity;

import java.io.Serializable;
import java.util.Date;

public class Entity implements Serializable{

	/**
	 *	version:基础实体
	 *----------------------
	 * 	author:xiezhyan
	 *	date:2017-5-31
	 */
	private static final long serialVersionUID = 1720067909658572102L;
	
	private Long id;
	private Long orderNum;
	private Date createTime = new Date();
	private Character isDelete = 'N';
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Character getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Character isDelete) {
		this.isDelete = isDelete;
	}
}
