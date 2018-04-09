package com.song.framework.support.proto;

import java.util.List;
import java.util.Map;

import com.song.framework.support.datasource.routing.RoutingDataSource;
import com.song.framework.support.datasource.routing.RoutingStrategy;
import com.song.framework.support.exception.DbException;

public interface ProtoMapper< T extends ProtoBean > {

    /**
     * 记录新增
     *
     * @param bean 需持久化的数据对象
     * @throws Exception 数据库访问异常
     */
	@RoutingDataSource(RoutingStrategy.WRITE)
    int insert( T bean ) throws DbException;
    
    /**
     * 批量新增记录
     * @param list
     * @return int
     * @throws Exception
     */
	@RoutingDataSource(RoutingStrategy.WRITE)
    int batchInsert(List<T> list) throws DbException;

    /**
     * 记录删除
     *
     * @param id 要删除记录的主键
     * @throws Exception 数据库访问异常
     */
	@RoutingDataSource(RoutingStrategy.WRITE)
    int delete( Object id ) throws DbException;

    /**
     * 记录更新
     *
     * @param bean 需持久化的数据对象
     * @throws Exception 数据库访问异常
     */
	@RoutingDataSource(RoutingStrategy.WRITE)
    int update( T bean ) throws DbException;
    
    /**
     * 根据版本号更新记录
     * @param bean
     * @return
     * @throws Exception
     */
	@RoutingDataSource(RoutingStrategy.WRITE)
    int updateByVersion(T bean) throws DbException;

    /**
     * 根据主键查询记录
     *
     * @param id 主键
     * @throws Exception 数据库访问异常
     */
	@RoutingDataSource(RoutingStrategy.READ)
    T selectById( Object id ) ;

    /**
     * 根据查询条件返回查询结果记录数。一般用于分页查询。
     *
     * @param map 查询条件映射
     * @throws Exception 数据库访问异常
     */
	@RoutingDataSource(RoutingStrategy.READ)
    Integer selectCount( Map< String, Object > map ) ;

    /**
     * 根据查询条件返回查询结果。
     *
     * @param map 查询条件映射
     * @throws Exception 数据库访问异常
     */
	@RoutingDataSource(RoutingStrategy.READ)
    List< T > selectList( Map< String, Object > map ) ;
}
