<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.dao.module;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tzg.service.support.proto.ProtoBean;

public class ${className} extends ProtoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    <#list table.columns as column>
    <#if column.isDateTimeColumn>
    public static final String FORMAT_${column.constantName} = "yyyy-MM-dd HH:mm:ss";
    </#if>
    </#list>
    
    //columns START
    <#list table.columns as column>
    /**
     * ${column.columnAlias!}
     */     
    <#if column.isDateTimeColumn>
    private ${column.javaType} ${column.columnNameFirstLower};
    private java.lang.String ${column.columnNameFirstLower}Str;
    <#else>
    private ${column.javaType} ${column.columnNameFirstLower};
    </#if>
    </#list>
    
    <@generateJavaColumns/>
    <@generateJavaOneToMany/>
    <@generateJavaManyToOne/>
    
}

<#macro generateJavaColumns>
    <#list table.columns as column>
        <#if column.isDateTimeColumn>
    public String get${column.columnName}Str() {
        if(get${column.columnName}() == null){
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_${column.constantName});
        this.${column.columnNameLower}Str = df.format(get${column.columnName}());
        return ${column.columnNameLower}Str;
    }
    public void set${column.columnName}Str(String value) {
        this.${column.columnNameLower}Str = value;
    }
    
        </#if>  
    public void set${column.columnName}(${column.javaType} value) {
        this.${column.columnNameLower} = value;
    }
    
    public ${column.javaType} get${column.columnName}() {
        return this.${column.columnNameLower};
    }
    </#list>
</#macro>

<#macro generateJavaOneToMany>
    <#list table.exportedKeys.associatedTables?values as foreignKey>
    <#assign fkSqlTable = foreignKey.sqlTable>
    <#assign fkTable    = fkSqlTable.className>
    <#assign fkPojoClass = fkSqlTable.className>
    <#assign fkPojoClassVar = fkPojoClass?uncap_first>
    
    private Set ${fkPojoClassVar}s = new HashSet(0);
    public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
        this.${fkPojoClassVar}s = ${fkPojoClassVar};
    }
    
    public Set<${fkPojoClass}> get${fkPojoClass}s() {
        return ${fkPojoClassVar}s;
    }
    </#list>
</#macro>

<#macro generateJavaManyToOne>
    <#list table.importedKeys.associatedTables?values as foreignKey>
    <#assign fkSqlTable = foreignKey.sqlTable>
    <#assign fkTable    = fkSqlTable.className>
    <#assign fkPojoClass = fkSqlTable.className>
    <#assign fkPojoClassVar = fkPojoClass?uncap_first>
    
    private ${fkPojoClass} ${fkPojoClassVar};
    
    public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
        this.${fkPojoClassVar} = ${fkPojoClassVar};
    }
    
    public ${fkPojoClass} get${fkPojoClass}() {
        return ${fkPojoClassVar};
    }
    </#list>
</#macro>
