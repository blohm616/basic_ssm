package maven_ssm.generation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import maven_ssm.generation.entity.TableEntity;
import maven_ssm.generation.mappers.TableMapper;
import maven_ssm.generation.service.TableService;

@Service("tableService")
public class TableServiceImpl implements TableService {

	@Resource
	private TableMapper tableMapper;
	
	@Override
	public List<TableEntity> findAllTables(String databaseName) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("codeSql", "SHOW TABLE STATUS " + databaseName);
		return tableMapper.findAllTables(map);
	}

}
