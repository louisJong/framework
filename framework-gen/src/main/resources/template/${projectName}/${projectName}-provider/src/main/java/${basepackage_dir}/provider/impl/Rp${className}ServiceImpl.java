<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
package ${basepackage}.provider.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${basepackage}.api.service.Rp${className}Service;
import ${basepackage}.biz.service.${className}Service;

@Service("rp${className}Service")
public class Rp${className}ServiceImpl implements Rp${className}Service {
    @Resource
    private ${className}Service ${classNameFirstLower}Service;

    
}
