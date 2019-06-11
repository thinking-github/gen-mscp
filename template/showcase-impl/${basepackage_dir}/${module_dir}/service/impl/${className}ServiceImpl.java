<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${module}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.camelot.itemSku.dto.ItemSkuDTO;
import com.camelot.itemSku.service.ItemSkuService;

import ${basepackage}.${classNameLower}.dto.${className}DTO;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
	
	@Resource
	private ${className}Service ${classNameLower}Service;
	
	@Override
	public ${className}DTO get${className}ById(long id) {
		${className} ${classNameLower} = ${classNameLower}Service.find${className}ById(id);
		
		${className}DTO ${classNameLower}DTO=new ${className}DTO();
		
		return ${classNameLower}DTO;
	}
}
