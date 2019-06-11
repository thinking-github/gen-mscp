<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${module}.service;


import ${basepackage}.${module}.dto.${className}DTO;

/**
 * <p>Description: [描述该类概要功能介绍]</p>
 * Created on 2016年4月26日
 * @author ${author}
 * @version 1.0 
 * Copyright (c) ${copyright}
 */
public interface ${className}Service {
	
	${className}DTO get${className}ById(long id);
}
