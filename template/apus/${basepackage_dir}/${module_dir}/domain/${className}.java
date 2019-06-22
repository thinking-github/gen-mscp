<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${module}.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>Description: [描述该类概要功能介绍]</p>
 * @author  ${author}
 * @since   ${currentDate}
 * @version ${version}
 * Copyright (c) ${copyright}
 */
@Entity
@Table(name = "${table.sqlName}")
public class ${className}  implements Serializable {
    
	private static final long serialVersionUID =1l;
	
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
