<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperPackage}.${table.name?cap_first}Mapper">

	<resultMap type="${entityPackage}.${table.name?cap_first}" id="${table.name}Map">
		<#list table.fieldEntity as field>
		<#if field.key == "PRI">
		<id column="${field.field}"  property="${field.javaField}"/>
		<#else>
		<result column="${field.field}" property="${field.javaField}"/>
		</#if>
		</#list>
	</resultMap>
	
    <select id="find" resultMap="${table.name}Map" parameterType="${entityPackage}.${table.name?cap_first}">
    </select>
    
    <select id="findAll" resultMap="${table.name}Map" parameterType="${entityPackage}.${table.name?cap_first}">
    </select>
    
    <select id="findAll" resultMap="${table.name}Map" >
    </select>
    
    <select id="findCount" parameterType="${entityPackage}.${table.name?cap_first}">
    </select>
    
    <delete id="delete" parameterType="${entityPackage}.${table.name?cap_first}">
    </delete>
    
    <update id="update" parameterType="${entityPackage}.${table.name?cap_first}">
    </update>
    
    <insert id="add" parameterType="${entityPackage}.${table.name?cap_first}">
    </insert>
</mapper>


