package maven_ssm.generation.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maven_ssm.generation.entity.FieldEntity;
import maven_ssm.generation.entity.TableEntity;
import maven_ssm.generation.service.FieldService;
import maven_ssm.generation.service.TableService;
import maven_ssm.utils.FileUtil;
import maven_ssm.utils.FreemarkerUtil;
import maven_ssm.utils.LogUtil;
import maven_ssm.utils.StringUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/code")
public class CodeController {

	@Resource
	private TableService tableService;
	@Resource
	private FieldService fieldService;
	
	@RequestMapping("/findAllTables")
	public String findAllTables(HttpServletRequest request,HttpServletResponse response,String packageName) {
		
		packageName = packageName.replace(".", File.separator);
		
		List<TableEntity> tables = tableService.findAllTables("");
		
		for(TableEntity table : tables) {
			List<FieldEntity> fields = fieldService.findFieldByTable(table.getName());
			if(fields != null && fields.size() > 0) {
				for(FieldEntity field: fields) {
					if(field.getType().contains("varchar")) {
						field.setJavaType("String");
					} else if(field.getType().contains("int")) {
						field.setJavaType("Integer");
					} else if(field.getType().contains("date")) {
						field.setJavaType("Date");
					} else if(field.getType().contains("double")) {
						field.setJavaType("Double");
					}
					field.setJavaField(StringUtil.getInstance().replaceChar(field.getField(), "_"));
				}
			}
			table.setFieldEntity(fields);
			request.setAttribute("table", table);
		}
		
		try {
			Map<String,Object> root = null;
			
			String entityPackage = packageName + File.separator + "entity";
			String servicePackage = packageName + File.separator + "service";
			String serviceImplPackage = packageName + File.separator + "service" + File.separator + "impl";
			String mapperPackage = packageName + File.separator + "mappers";
			
			for(TableEntity table : tables) {
				root = new HashMap<String,Object>();
				
				root.put("table", table);
				root.put("packageName", packageName.replace(File.separator, "."));
				root.put("entityPackage", entityPackage.replace(File.separator, "."));
				root.put("servicePackage", servicePackage.replace(File.separator, "."));
				root.put("serviceImplPackage", serviceImplPackage.replace(File.separator, "."));
				root.put("mapperPackage", mapperPackage.replace(File.separator, "."));
				
				String path = request.getContextPath() + File.separator + entityPackage;
				
				//entity
				FreemarkerUtil.getInstance().tempWriter(request.getRealPath("/WEB-INF/ftl/generation"), 
							"entity.ftl", path, StringUtil.getInstance().firstUpperCase(table.getName()) + ".java", root);
				
				//serivce
				path = request.getContextPath() + File.separator + servicePackage;
				FreemarkerUtil.getInstance().tempWriter(request.getRealPath("/WEB-INF/ftl/generation"), 
						"service.ftl", path, StringUtil.getInstance().firstUpperCase(table.getName()) + "Service.java", root);
				
				//serviceImpl
				path = request.getContextPath() + File.separator + serviceImplPackage;
				FreemarkerUtil.getInstance().tempWriter(request.getRealPath("/WEB-INF/ftl/generation"), 
						"service_impl.ftl", path, StringUtil.getInstance().firstUpperCase(table.getName()) + "ServiceImpl.java", root);
				
				//mapper
				path = request.getContextPath() + File.separator + mapperPackage;
				FreemarkerUtil.getInstance().tempWriter(request.getRealPath("/WEB-INF/ftl/generation"), 
						"mapper.ftl", path, StringUtil.getInstance().firstUpperCase(table.getName()) + "Mapper.java", root);
				
				//mapper.xml
				path = request.getContextPath() + File.separator + mapperPackage;
				FreemarkerUtil.getInstance().tempWriter(request.getRealPath("/WEB-INF/ftl/generation"), 
						"mapper_xml.ftl", path, StringUtil.getInstance().firstUpperCase(table.getName()) + "Mapper.xml", root);
			}
			FileUtil.getInstance().compressExe(request.getContextPath() + File.separator + FreemarkerUtil.getInstance().getParentPath(packageName), "D:\\"+FreemarkerUtil.getInstance().getParentPath(packageName)+".zip");
			LogUtil.i("压缩完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "tables.ftl";
	}
}
