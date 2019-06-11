<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
<#assign pkColumn = table.pkColumn>
<#assign pkType = table.pkColumn.javaType> 
package ${basepackage}.${module}.service;

import java.util.List;

import org.nbone.common.model.ExecuteResult;
import org.nbone.common.model.DataGrid;
import org.nbone.common.model.Pager;
import org.nbone.mvc.service.SuperService;

import ${basepackage}.${module}.dto.${className}DTO;


/**
 * <p>[描述该类概要功能介绍]</p>
 * @author ${author}
 * @since  ${currentDate}
 * @version ${version}
 * Copyright (c) ${copyright}
 */
public interface ${className}Service extends SuperService<${className}DTO, ${pkType}> {

	/**
	 * 
	 * <p>Discription:[增加]</p>
	 * @param ${classNameLower}DTO 
	 * @return
	 */
	public ${pkType} add${className} (${className}DTO ${classNameLower});
	
	/**
	 * 
	 * <p>Discription:[删除]</p>
	 * @param ${classNameLower}DTO （${classNameLower}Id不能为空）
	 * @return
	 */
	public boolean delete${className} (${className}DTO ${classNameLower});
	
	public boolean delete${className}(${pkType} id);
	
	/**
	 * 
	 * <p>Discription:[修改]</p>
	 * @param ${classNameLower}DTO （${classNameLower}Id不能为空）
	 * @return
	 */
	public boolean modify${className} (${className}DTO ${classNameLower});
	
	/**
	 * 
	 * <p>Discription:[根据id查询]</p>
	 * @param ${classNameLower}Id 必传项
	 * @return
	 */
	public ${className}DTO get${className}ById(${pkType} id);
	
	/**
	 * 
	 * <p>Discription:[查询]</p>
	 * @param ${classNameLower}DTO
	 * @param pager
	 * @return
	 */
	public DataGrid<${className}DTO> query${className}s(${className}DTO ${classNameLower},Pager<${className}DTO> pager);
	/**
	 * 
	 * <p>Discription:[查询]</p>
	 * @param ${classNameLower}DTO
	 * @return
	 */
	public List<${className}DTO> query${className}s(${className}DTO ${classNameLower});
	
	/**
	 * * 根据查询条件查询数据
	 *  <li> 1.当返回<=0条数据时返回null
	 *  <li> 2.当返回=1条数据时直接返回
	 *  <li> 3.当返回>1数据时只取第一条
	 * @param ${classNameLower}DTO
	 * @return
	 */
	public ${className}DTO query${className}(${className}DTO ${classNameLower});

}
