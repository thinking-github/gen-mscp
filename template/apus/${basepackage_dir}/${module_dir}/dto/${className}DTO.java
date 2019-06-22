<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${module}.dto;
import java.io.Serializable;

/**
 * <p>Description: [描述该类概要功能介绍]</p>
 * Created on 2016年4月26日
 * @author ${author}
 * @version 1.0 
 * Copyright (c) ${copyright}
 */
public class ${className}DTO  implements Serializable{
	<@generateFields/>
	
	<@generateProperties/>
	
}

<#macro generateFields>
<#list table.columns as column>
	/** ${column.columnAlias} */
	private ${column.javaType} ${column.columnNameLower};
	
</#list>
</#macro>

<#macro generateProperties>
<#list table.columns as column>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
</#list>
</#macro>