package maven_ssm.generation.entity;

import java.io.Serializable;

public class FieldEntity implements Serializable {

	/**
	 *	version: 字段表
	 *----------------------
	 * 	author:xiezhyan
	 *	date:2017-6-4
	 */
	private static final long serialVersionUID = 6482847865746417225L;

	//所属字段
	private String field;
	//字段类型
	private String type;
	//字段编码
	private String collation;
	//字段是否是主键，外键等
	private String key;
	
	private String extra;
	
	private String comment;

	private String javaType;
	
	private String javaField;
	
	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaField() {
		return javaField;
	}

	public void setJavaField(String javaField) {
		this.javaField = javaField;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCollation() {
		return collation;
	}

	public void setCollation(String collation) {
		this.collation = collation;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
