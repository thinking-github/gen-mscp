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

import org.nbone.mvc.service.BaseServiceDtoDomain;
import org.nbone.mvc.service.BaseServiceDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import org.nbone.common.model.ExecuteResult;
import org.nbone.common.model.DataGrid;
import org.nbone.common.model.Pager;
import ${basepackage}.${module}.domain.${className};
import ${basepackage}.${module}.dto.${className}DTO;
import ${basepackage}.${module}.dao.${className}DAO;
import ${basepackage}.${module}.service.${className}Service;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends BaseServiceDomain<${className}DTO,${pkColumn.javaType}> implements ${className}Service{
	
	private final static Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);
	
	@Resource
	private ${className}DAO ${classNameLower}DAO;
	
	@PostConstruct
	@Override
	protected void initMybatisOrm() {
		super.initMybatisOrm(${className}DAO.class,"${classNameLower}Map");
	}
	

	@Override
	public ${pkColumn.javaType} add${className}(${className}DTO ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		${pkColumn.javaType} id = null;
		try {
			
			id = this.save(${classNameLower});
			
		} catch (Exception e) {
			id = -1;
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(id));
		return id;
	}

	@Override
	public boolean delete${className}(${className}DTO ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		
		try {
			
			Long ${classNameLower}Id = ${classNameLower}.getId();
			if(${classNameLower}Id == null || ${classNameLower}Id == 0){
				logger.error("id输入参数不能为空.");
				return false;
			}
			
			//${classNameLower}DAO.delete(${classNameLower}Id);
			this.delete(${classNameLower}Id);
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete${className}(${pkColumn.javaType} id){
		logger.debug("输入参数：[{}]",id);
		try {
			
			if(id == null){
				logger.error("id输入参数不能为空.");
				return false;
			}
			
			//${classNameLower}DAO.delete(id);
			this.delete(id);
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
			return false;
		}
		return true;
	}
	
	@Override
	public boolean modify${className}(${className}DTO ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		try {
			
			Long ${classNameLower}Id = ${classNameLower}.getId();
			if(${classNameLower}Id == null || ${classNameLower}Id == 0){
				logger.error("id输入参数不能为空.");
				return false;
			}
			this.updateSelective(${classNameLower});
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
			return false;
		}
		return true;
	}
	
	@Override
	public ${className}DTO get${className}ById(${pkColumn.javaType} id) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(id));
		${className}DTO	${classNameLower} = null;
		try {
			
			if(id == null || id == 0){
				logger.error("id输入参数不能为空.");
				return null;
			}
			
			${classNameLower} = this.get(id);
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		return ${classNameLower};
	}
	
	@Override
	public DataGrid<${className}DTO> query${className}s(${className}DTO ${classNameLower}, Pager<${className}DTO> pager) {
		
		logger.debug("输入参数：[{},{}]",JSONObject.toJSONString(${classNameLower}),JSONObject.toJSONString(pager));
		DataGrid<${className}DTO> dataGrid =new DataGrid<${className}DTO>();
		try {
			//查询数量
			Long count = ${classNameLower}DAO.queryCount(${classNameLower},null);
			dataGrid.setTotal(count);
			if(count > 0){
				//查询list
				List<${className}DTO> list = ${classNameLower}DAO.queryList(${classNameLower}, pager,null);
				dataGrid.setRows(list);
			}
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(dataGrid));
		return dataGrid;
	}
	
	@Override
	public List<${className}DTO> query${className}s(${className}DTO ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		List<${className}DTO> list = null;
		try {
			//查询list
			 list = this.getForList(${classNameLower});
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(list));
		return list;
	}
	
	@Override
	public ${className}DTO query${className}(${className}DTO ${classNameLower}) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}));
		${className}DTO result = null;
		try {
			
			//查询list
			List<${className}DTO> list = this.getForList(${classNameLower});
			if(list != null && list.size() > 0 ){
				result = list.get(0);
			}
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}

}
