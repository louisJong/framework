package com.song.framework.support.proto;

import java.util.List;
import java.util.Map;

import com.song.framework.support.exception.DbException;

public abstract  class AbstractProtoService<T extends ProtoBean> implements ProtoService<T> {

	protected abstract ProtoMapper<T> getMapper();

	public long insert(T bean) throws DbException {
		getMapper().insert(bean);
		if(bean.getId()==null)
			throw DbException.DB_INSERT_RESULT_NULL;
		return bean.getId();
	}

	public void batchInsert(List<T> beans) throws DbException {
		getMapper().batchInsert(beans);
	}

	public T seiectById(Object id) {
		return getMapper().selectById(id);
	}
	
	public int update(T bean) throws DbException {
		int count = getMapper().update(bean);
		if(count==0)
			throw DbException.DB_UPDATE_RESULT_0;
		return count;
	}

	public int updateByVersion(T bean) throws DbException {
		int count = getMapper().updateByVersion(bean);
		if(count==0)
			throw DbException.DB_UPDATE_RESULT_0;
		return count;
	}

	public int delete(Object id) throws DbException {
		return getMapper().delete(id);
	}

	public List<T> selectList(Map<String, Object> params) {
		return getMapper().selectList(params);
	}

	public long selectCount(Map<String, Object> params) {
		return getMapper().selectCount(params);
	}

}
