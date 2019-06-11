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

import ${basepackage}.${module}.domain.${className};



/**
 * <p>[描述该类概要功能介绍]</p>
 * @author ${author}
 * @since  ${currentDate}
 * @version ${version}
 * Copyright (c) ${copyright}
 */
public interface ${className}Service extends SuperService<${className}, ${pkType}> {

	/**
	 * 
	 * <p>Discription:[增加]</p>
	 * @param ${classNameLower}
	 * @return
	 */
	public ${pkType} add${className} (${className}  ${classNameLower});
	
	/**
	 * 
	 * <p>Discription:[删除]</p>
	 * @param ${classNameLower} （${classNameLower}Id不能为空）
	 * @return
	 */
	public boolean delete${className} (${className} ${classNameLower});
	
	public boolean delete${className}(${pkType} id);
	
	/**
	 * 
	 * <p>Discription:[修改]</p>
	 * @param ${classNameLower} （${classNameLower}Id不能为空）
	 * @return
	 */
	public boolean modify${className} (${className} ${classNameLower});
	
	/**
	 * 
	 * <p>Discription:[根据id查询]</p>
	 * @param id 必传项
	 * @return
	 */
	public ${className} get${className}ById(${pkType} id);
	
	/**
	 * 
	 * <p>Discription:[分页查询]</p>
	 * @param ${classNameLower}
	 * @param pager
	 * @return
	 */
	//public DataGrid<${className}> query${className}s(${className} ${classNameLower},Pager<${className}> pager);
	
	/**
	 * 分页查询
	 * @param ${classNameLower}
	 * @param pageNow 当前页码
	 * @param pageSize 单页的大小
	 * @return
	 */
	public DataGrid<${className}> query${className}s(${className} ${classNameLower}, int pageNow, int pageSize);
	/**
	 * 
	 * <p>Discription:[列表查询]</p>
	 * @param ${classNameLower}
	 * @return
	 */
	public List<${className}> query${className}s(${className} ${classNameLower});
	
	/**
	 * * 根据查询条件查询数据
	 *  <li> 1.当返回<=0条数据时返回null
	 *  <li> 2.当返回=1条数据时直接返回
	 *  <li> 3.当返回>1数据时只取第一条
	 * @param ${classNameLower}
	 * @return
	 */
	public ${className} query${className}(${className} ${classNameLower});

}
