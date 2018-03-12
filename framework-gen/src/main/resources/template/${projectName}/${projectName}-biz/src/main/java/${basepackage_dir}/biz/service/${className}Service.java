<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
package ${basepackage}.biz.service;

import com.tzg.service.support.proto.ProtoService;
import ${basepackage}.dao.module.${className};

public interface ${className}Service extends ProtoService<${className}> {
    
}
