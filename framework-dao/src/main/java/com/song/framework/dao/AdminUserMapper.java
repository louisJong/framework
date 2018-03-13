package com.song.framework.dao ;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.song.framework.dao.base.ProtoMapper;
import com.song.framework.dao.module.AdminUser;

@Repository
public interface AdminUserMapper extends ProtoMapper<AdminUser> {

	public int modifyLoginPwd(Map<String, Object> params);
  
	public AdminUser findByUserNameAndPwd(Map<String, String> param) ;
	
}
