package maven_ssm.basic.service;

import java.util.List;

import maven_ssm.basic.entity.Pager;

public interface BaseService<T> {
	
	/**
	 * 
	 *	version:添加
	 *	@param t
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	int add(T t);
	
	/**
	 * 
	 *	version:删除
	 *	@param t
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	int delete(T t);
	
	/**
	 * 
	 *	version:修改
	 *	@param t
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	int update(T t);
	
	/**
	 * 
	 *	version:通过条件查询
	 *	@param id
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	T find(T t);
	
	/**
	 * 
	 *	version:查询所有数据
	 *	@param t	条件
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	List<T> findAll(T t);
	
	/**
	 * 
	 *	version:分页查询
	 *	@param t	条件
	 *	@param pager	分页数据
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	Pager<T> findAll(T t,Pager<T> pager);
	
	/**
	 * 
	 *	version:查询数据条数
	 *	@param t
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-9
	 */
	int findCount(T t);
}
