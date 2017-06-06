package maven_ssm.generation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import maven_ssm.generation.entity.FieldEntity;
import maven_ssm.generation.mappers.FieldMapper;
import maven_ssm.generation.service.FieldService;

import org.springframework.stereotype.Service;

@Service("fieldService")
public class FieldServiceImpl implements FieldService {

	@Resource
	private FieldMapper fieldMapper;
	
	@Override
	public List<FieldEntity> findFieldByTable(String tableName) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("tableName", tableName);
		
		return fieldMapper.findFieldByTable(map);
	}
	
	
}
