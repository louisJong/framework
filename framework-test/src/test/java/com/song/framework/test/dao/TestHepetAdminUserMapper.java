package com.song.framework.test.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.song.framework.dao.AdminUserMapper;

@WebAppConfiguration
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = {
        "classpath*:applicationContext-corel"
} )
public class TestHepetAdminUserMapper {
    private static final Logger logger = Logger.getLogger(TestHepetAdminUserMapper.class.getName());

    @Resource
    private AdminUserMapper adminUserMapper;

    @Test
    public void testMapperNotNull() {
        Assert.assertNotNull( adminUserMapper );
    }

}
