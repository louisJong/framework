<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
package ${basepackage}.test.biz;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ${basepackage}.biz.service.${className}Service;

@WebAppConfiguration
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = {
        "classpath*:/spring/context.xml",
        "classpath*:/spring/dispatcher.xml"
} )
public class Test${className}Service {
    private static final Logger logger = LoggerFactory.getLogger(Test${className}Service.class.getName());

    @Resource
    private ${className}Service ${classNameFirstLower}Service;

    @Test
    public void testServiceNotNull() {
        Assert.assertNotNull( ${classNameFirstLower}Service );
    }

}
