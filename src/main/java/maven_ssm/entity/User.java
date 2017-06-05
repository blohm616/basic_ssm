package maven_ssm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class User implements Serializable {

	/**
	 * 用户信息表
	 */
	private static final long serialVersionUID = 8268979577074199081L;
	
	private Long id;
	private String username;
	private String password;
	private Date createTime = new Date();
	private String userId = UUID.randomUUID().toString().replace("-", "");
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
