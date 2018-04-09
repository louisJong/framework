package com.song.framework.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.song.framework.dao.module.AdminUser;
import com.song.framework.support.proto.ProtoService;

public interface UserService extends ProtoService<AdminUser>{

	JSONObject login(String userName, String loginPwd);

	JSONObject modifyLoginPwd(Long userId, String oldPwd, String newPwd);

}
