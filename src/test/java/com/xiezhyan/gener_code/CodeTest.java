package com.xiezhyan.gener_code;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maven_ssm.utils.FileUtil;
import maven_ssm.utils.FreemarkerUtil;
import maven_ssm.utils.LogUtil;
import maven_ssm.utils.StringUtil;
import maven_ssm.utils.XmlUtil;

import org.junit.Test;

public class CodeTest {

	@Test
	public void generCode() {
		String packageName = "com.xiezhyan.getbetter.entity";
		String newPackageName = packageName.replace(".", File.separator);
		File packageDir = new File(newPackageName);
		if(!packageDir.exists())
			packageDir.mkdirs();
	}
	
	@Test
	public void freemarkerTest() {
		try {
			Map<String,Object> root = new HashMap<String,Object>();
			root.put("hello", "hello Freemarker");
			String filePath = FreemarkerUtil.getInstance().tempWriter("F:\\projects" , "index.ftl", "d://a//bb","a.txt" , root);
			FileUtil.getInstance().compressExe(filePath, "D:\\aa.zip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void xmlTest() {
		List<Map<String, String>> parse = XmlUtil.getInstance().parse("F:\\projects\\MyEclipse\\basic_ssm Maven Webapp\\pom.xml");
		for(Map<String, String> map : parse) {
			for(Map.Entry<String, String> entry : map.entrySet()) {
				LogUtil.i(entry.getKey() + ":::" + entry.getValue());
			}
		}
	}
	
	@Test
	public void stringTest() {
		String str  = "";
		
		System.out.println(StringUtil.getInstance().firstUpperCase(str));
	}
}
