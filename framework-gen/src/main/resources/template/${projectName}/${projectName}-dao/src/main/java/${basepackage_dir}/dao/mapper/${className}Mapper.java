<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.mapper;

import org.springframework.stereotype.Repository;

import com.tzg.service.support.proto.ProtoMapper;
import ${basepackage}.dao.module.${className};

@Repository
public interface ${className}Mapper extends ProtoMapper<${className}> {	

}
