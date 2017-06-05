package maven_ssm.generation.mappers;

import java.util.List;
import java.util.Map;

import maven_ssm.generation.entity.TableEntity;

public interface TableMapper {

	List<TableEntity> findAllTables(Map<String,String> map);
}
