<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${module}.dao;

import org.nbone.mybatis.dao.BaseDAO;
import ${basepackage}.${module}.domain.${className};

/**
 * <p>Description: [描述该类概要功能介绍]</p>
 * @author ${author}
 * @since  ${currentDate}
 * @version ${version}
 * Copyright (c) ${copyright}
 */
public interface ${className}DAO  extends BaseDAO<${className}>{
	
}