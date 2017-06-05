package maven_ssm.generation.service;

import java.util.List;

import maven_ssm.generation.entity.FieldEntity;

public interface FieldService {

	public List<FieldEntity> findFieldByTable(String tableName);

}