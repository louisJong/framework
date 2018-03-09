package com.song.project.mchealth.dao.test;

import org.unitils.spring.annotation.SpringBean;

import com.song.framework.dao.AdminUserDao;

public class DaoTest extends BaseTestCase{

	@SpringBean("adminUserDao")
	AdminUserDao userDao;
	
	public void test_01(){
		System.out.println(userDao.findById(1l));
	}
}
