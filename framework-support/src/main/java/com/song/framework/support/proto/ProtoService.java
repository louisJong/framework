package com.song.framework.support.proto;

import java.util.List;
import java.util.Map;

import com.song.framework.support.exception.DbException;

public interface ProtoService<T extends ProtoBean> {

	long insert(T bean) throws DbException;
	
	void batchInsert(List<T> beans) throws DbException;
	
	T seiectById(Object id);
	
	int update(T bean) throws DbException;
	
	int updateByVersion(T bean) throws DbException;
	
	int delete(Object id) throws DbException;
	
	List<T> selectList(Map<String , Object> params);
	
	long selectCount(Map<String , Object> params);

}
