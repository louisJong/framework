package com.song.framework.admin.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {

	JSONObject login(String userName, String loginPwd);

	JSONObject modifyLoginPwd(Long userId, String oldPwd, String newPwd);

}
