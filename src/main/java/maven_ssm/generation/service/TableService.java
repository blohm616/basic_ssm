package maven_ssm.generation.service;

import java.util.List;

import maven_ssm.generation.entity.TableEntity;

public interface TableService {

	List<TableEntity> findAllTables(String databaseName);
	
}
