<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
<#assign pkColumn = table.pkColumn> 
<#assign pkType = table.pkColumn.javaType> 

package ${basepackage}.${module}.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import org.nbone.mvc.service.BaseServiceDtoDomain;
import org.nbone.mvc.service.BaseServiceDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.alibaba.fastjson.JSONObject;
import org.nbone.common.model.ExecuteResult;
import org.nbone.common.model.DataGrid;
import org.nbone.common.model.Pager;
import ${basepackage}.${module}.domain.${className};
//import ${basepackage}.${module}.dto.${className}DTO;
//import ${basepackage}.${module}.dao.${className}DAO;
import ${basepackage}.${module}.service.${className}Service;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends BaseServiceDomain<${className},${pkColumn.javaType}> implements ${className}Service{
	
	private final static Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);
	
	@Resource
	private ${className}Dao ${classNameLower}Dao;

	@PostConstruct
	@Override
	protected void initMybatisOrm() {
		//BaseResultMap   ${classNameLower}Map
		super.initMybatisOrm(${className}Dao.class,"BaseResultMap");
	}
	

	@Override
	public ${pkColumn.javaType} add${className}(${className} ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		${pkColumn.javaType} id = null;

		id = this.save(${classNameLower});

		logger.debug("输出参数：[{}]",JSONObject.toJSONString(id));
		return id;
	}

	@Override
	public boolean delete${className}(${className} ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));

		Long ${classNameLower}Id = ${classNameLower}.getId();
		Assert.notNull(${classNameLower}Id,"id输入参数不能为空.");

		this.delete(${classNameLower}Id);

		return true;
	}

	@Override
	public boolean delete${className}(${pkColumn.javaType} id){
		logger.debug("输入参数：[{}]",id);
		Assert.notNull(id,"id输入参数不能为空.");

		this.delete(id);

		return true;
	}
	
	@Override
	public boolean modify${className}(${className} ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
			
		Long ${classNameLower}Id = ${classNameLower}.getId();
		Assert.notNull(${classNameLower}Id,"id输入参数不能为空.");

		this.updateSelective(${classNameLower});

		return true;
	}
	
	@Override
	public ${className} get${className}ById(${pkColumn.javaType} id) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(id));
		${className} ${classNameLower} = null;

		Assert.notNull(id,"id输入参数不能为空.");

		${classNameLower} = this.get(id);

		logger.debug("输出参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		return ${classNameLower};
	}
	
	/*@Override
	public DataGrid<${className}> query${className}s(${className} ${classNameLower}, Pager<${className}> pager) {
		
		logger.debug("输入参数：[{},{}]",JSONObject.toJSONString(${classNameLower}),JSONObject.toJSONString(pager));
		DataGrid<${className}> dataGrid =new DataGrid<${className}>();
		try {
			//查询数量
			Long count = ${classNameLower}DAO.queryCount(${classNameLower},null);
			dataGrid.setTotal(count);
			if(count > 0){
				//查询list
				List<${className}> list = ${classNameLower}DAO.queryList(${classNameLower}, pager,null);
				dataGrid.setRows(list);
			}
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(dataGrid));
		return dataGrid;
	}*/
	
	@Override
	public DataGrid<${className}> query${className}s(${className} ${classNameLower}, int pageNow, int pageSize) {
		logger.debug("输入参数：[{},{},{}]",JSONObject.toJSONString(${classNameLower}),pageNow,pageSize);
		Page<${className}> page = null;
		page = super.queryForPage(${classNameLower},pageNow,pageSize);

		logger.debug("输出参数：[{}]",JSONObject.toJSONString(page));
		return this.to(page);
	}
	
	@Override
	public List<${className}> query${className}s(${className} ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		List<${className}> list = null;
		//查询list
		list = this.getForList(${classNameLower});
			
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(list));
		return list;
	}
	
	@Override
	public ${className} query${className}(${className} ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		${className} result = null;

		//查询list
		List<${className}> list = this.getForList(${classNameLower});
		if(list != null && list.size() > 0 ){
			result = list.get(0);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}

}
