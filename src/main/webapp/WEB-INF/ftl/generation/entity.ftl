package ${entityPackage};

import java.io.Serializable;
import java.util.*;

public class ${table.name?cap_first} implements Serializable {

	/**
	 *	version: ${table.comment}
	 *----------------------
	 * 	author:xiezhyan
	 */
	private static final long serialVersionUID = 6482847865746417225L;
	
	<#list table.fieldEntity as field>
	/**${field.comment}*/
	private ${field.javaType} ${field.javaField};
	</#list>
	<#list table.fieldEntity as field>
	public ${field.javaType} get${field.javaField?cap_first}() {
		return ${field.javaField};
	}

	public void set${field.javaField?cap_first}(${field.javaType} ${field.javaField}) {
		this.${field.javaField} = ${field.javaField};
	}
	</#list>

}
