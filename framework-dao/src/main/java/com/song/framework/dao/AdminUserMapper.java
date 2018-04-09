package com.song.framework.dao ;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.song.framework.dao.module.AdminUser;
import com.song.framework.support.datasource.routing.RoutingDataSource;
import com.song.framework.support.datasource.routing.RoutingStrategy;
import com.song.framework.support.proto.ProtoMapper;

@Repository
public interface AdminUserMapper extends ProtoMapper<AdminUser> {

	@RoutingDataSource(RoutingStrategy.WRITE)
	public int modifyLoginPwd(Map<String, Object> params);
  
	@RoutingDataSource(RoutingStrategy.READ)
	public AdminUser findByUserNameAndPwd(Map<String, String> param) ;

}
