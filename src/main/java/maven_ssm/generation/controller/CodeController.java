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
			table.setFieldEntity(fields);
			request.setAttribute("table", table);
		}
		
		try {
			Map<String,Object> root = null;
			for(TableEntity table : tables) {
				root = new HashMap<String,Object>();
				root.put("table", table);
				LogUtil.i(table.getName());
				FreemarkerUtil.getInstance().tempWriter(request.getRealPath("/WEB-INF/ftl"), "tables.ftl", 
							request.getContextPath() + File.separator +
							packageName + File.separator + "entity", table.getName() + ".java", root);
			}
			FileUtil.getInstance().compressExe(FreemarkerUtil.getInstance().getParentPath(packageName), "D:\\"+FreemarkerUtil.getInstance().getParentPath(packageName)+".zip");
			LogUtil.i("压缩完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "tables.ftl";
	}
}
