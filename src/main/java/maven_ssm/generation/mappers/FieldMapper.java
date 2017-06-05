package maven_ssm.generation.mappers;

import java.util.List;
import java.util.Map;

import maven_ssm.generation.entity.FieldEntity;

public interface FieldMapper {

	List<FieldEntity> findFieldByTable(Map<String,String> map);
}
