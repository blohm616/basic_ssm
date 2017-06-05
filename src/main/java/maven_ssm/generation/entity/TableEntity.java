package maven_ssm.generation.entity;

import java.io.Serializable;
import java.util.List;

public class TableEntity implements Serializable {

	/**
	 *	version: 表名
	 *----------------------
	 * 	author:xiezhyan
	 *	date:2017-6-4
	 */
	private static final long serialVersionUID = 6204772647475628441L;

	private String name;
	private String comment;
	
	private List<FieldEntity> fieldEntity;
	
	
	public List<FieldEntity> getFieldEntity() {
		return fieldEntity;
	}
	public void setFieldEntity(List<FieldEntity> fieldEntity) {
		this.fieldEntity = fieldEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
