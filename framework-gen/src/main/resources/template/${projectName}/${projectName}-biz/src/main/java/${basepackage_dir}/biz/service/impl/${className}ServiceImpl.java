<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
package ${basepackage}.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzg.service.support.proto.ProtoMapper;
import com.tzg.service.support.proto.ProtoServiceImpl;
import ${basepackage}.dao.module.${className};
import ${basepackage}.biz.service.${className}Service;
import ${basepackage}.dao.mapper.${className}Mapper;

@Service("${classNameFirstLower}Service")
public class ${className}ServiceImpl extends ProtoServiceImpl<${className}> implements ${className}Service  {

	@Autowired
	private ${className}Mapper ${classNameFirstLower}Mapper;	
	   
	@Override
    protected ProtoMapper<${className}> getMapper() {
        return ${classNameFirstLower}Mapper;
    }   
	
}
