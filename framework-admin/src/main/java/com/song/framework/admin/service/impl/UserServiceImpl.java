package com.song.framework.admin.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.song.framework.admin.service.UserService;
import com.song.framework.dao.AdminUserMapper;
import com.song.framework.dao.module.AdminUser;
import com.song.framework.support.proto.AbstractProtoService;
import com.song.framework.support.proto.ProtoMapper;
import com.song.framework.support.utils.JsonUtils;
import com.song.framework.support.utils.MD5Util;

@Service
public class UserServiceImpl extends AbstractProtoService<AdminUser> implements UserService {

	private static final Logger logger  = Logger.getLogger(UserServiceImpl.class);
	
	String pwd_mask = "HePET1212";
	
	@Autowired
	private AdminUserMapper userDao;
	
	private String getEncreptPwd(String pwd){
		return MD5Util.MD5Encode(pwd_mask+pwd, "utf-8");
	}

	@Override
	public JSONObject login(String userName, String loginPwd) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("userName", userName);
		param.put("loginPwd", getEncreptPwd(loginPwd));
		AdminUser user = userDao.findByUserNameAndPwd(param);
		if(user==null){
			return JsonUtils.commonJsonReturn("0002" , "用户名或密码错误");
		}
		if(user.getStatus()==0){
			return JsonUtils.commonJsonReturn("0003" , "账户不可用");
		}
		JSONObject result = JsonUtils.commonJsonReturn();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute("user", user);
		return result;
	}

	@Override
	public JSONObject modifyLoginPwd(Long userId, String oldPwd, String newPwd) {
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("oldPwd", getEncreptPwd(oldPwd));
		params.put("newPwd", getEncreptPwd(newPwd));
		int effectCount = userDao.modifyLoginPwd(params);
		if(effectCount==0){
			return JsonUtils.commonJsonReturn("0001", "原始密码错误");
		}
		return JsonUtils.commonJsonReturn();
	}

	@Override
	protected ProtoMapper<AdminUser> getMapper() {
		return userDao;
	}

}
