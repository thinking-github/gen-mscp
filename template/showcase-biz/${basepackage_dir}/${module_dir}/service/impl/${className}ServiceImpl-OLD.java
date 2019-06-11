<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
<#assign pkColumn = table.pkColumn> 

package ${basepackage}.${module}.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.PostConstruct;

import org.nbone.mvc.service.BaseServiceDtoDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.camelot.lrpbasicdata.sdk.service.adapter.CdOrderTypeServiceMapingExportServiceAdapter;
import com.camelot.market.sdk.dto.MarketItemPriceDTO;
import com.camelot.openplatform.common.bean.BeanMapper;
import com.camelot.openplatform.common.bean.BeanUtil;
import com.camelot.openplatform.common.bean.DataGrid;
import com.camelot.openplatform.common.bean.ExecuteResult;
import com.camelot.openplatform.common.bean.Pager;
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
	public ${pkColumn.javaType} add${className}(${className}DTO ${classNameLower}DTO) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}DTO));
		${pkColumn.javaType} id = null;
		try {
			
			id = this.save(${classNameLower}DTO);
			
		} catch (Exception e) {
			id = -1;
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(id));
		return id;
	}

	@Override
	public ExecuteResult<String> delete${className}(${className}DTO ${classNameLower}DTO) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}DTO));
		ExecuteResult<String> result =new ExecuteResult<String>();
		try {
			
			Long ${classNameLower}Id = ${classNameLower}DTO.getId();
			if(${classNameLower}Id==null || ${classNameLower}Id==0){
				result.addErrorMessage("id不能为空");
				return result;
			}
			
			//${classNameLower}DAO.delete(${classNameLower}Id);
			this.delete(${classNameLower}Id);
			result.setResultMessage("删除成功");
			
		} catch (Exception e) {
			result.addErrorMessage(e.getMessage());
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public ExecuteResult<String> delete${className}(${pkColumn.javaType} id){
		logger.debug("输入参数：[{}]",id);
		ExecuteResult<String> result =new ExecuteResult<String>();
		try {
			
			if(id == null){
				result.addErrorMessage("id不能为空");
				return result;
			}
			
			//${classNameLower}DAO.delete(id);
			this.delete(id);
			result.setResultMessage("删除成功");
			
		} catch (Exception e) {
			result.addErrorMessage(e.getMessage());
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}
	
	@Override
	public ExecuteResult<String> modify${className}(${className}DTO ${classNameLower}DTO) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}DTO));
		ExecuteResult<String> result =new ExecuteResult<String>();
		try {
			
			Long ${classNameLower}Id = ${classNameLower}DTO.getId();
			if(${classNameLower}Id == null || ${classNameLower}Id == 0){
				result.addErrorMessage("id不能为空");
				return result;
			}
			this.updateSelective(${classNameLower}DTO);
			result.setResultMessage("修改成功");
			
		} catch (Exception e) {
			result.addErrorMessage(e.getMessage());
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}
	
	@Override
	public ExecuteResult<${className}DTO> get${className}ById(Long id) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(id));
		ExecuteResult<${className}DTO> result=new ExecuteResult<${className}DTO>();
		try {
			
			if(id==null || id==0){
				result.addErrorMessage("用户id不能为空");
				return result;
			}
			
			${className}DTO	${classNameLower}DTO = this.get(id);
			result.setResult(${classNameLower}DTO);
			result.setResultMessage("查询成功");
			
		} catch (Exception e) {
			result.addErrorMessage(e.getMessage());
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}
	
	@Override
	public ExecuteResult<DataGrid<${className}DTO>> query${className}s(${className}DTO ${classNameLower}DTO, Pager<${className}DTO> pager) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}DTO),JSONObject.toJSONString(pager));
		ExecuteResult<DataGrid<${className}DTO>> result =new ExecuteResult<DataGrid<${className}DTO>>();
		try {
			
			DataGrid<${className}DTO> dataGrid =new DataGrid<${className}DTO>();
			
			${className} ${classNameLower} = new ${className}();
			BeanUtil.copyProperties(${classNameLower}DTO, ${classNameLower});
			//查询数量
			Long count = ${classNameLower}DAO.queryCount(${classNameLower},null);
			dataGrid.setTotal(count);
			if(count>0){
				//查询list
				List<${className}> list = ${classNameLower}DAO.queryList(${classNameLower}, pager,null);
				dataGrid.setRows(BeanMapper.mapList(list, ${className}DTO.class));
			}
			result.setResult(dataGrid);
			result.setResultMessage("查询成功");
		} catch (Exception e) {
			result.addErrorMessage(e.getMessage());
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(result));
		return result;
	}
	
	@Override
	public List<${className}DTO> query${className}s(${className}DTO ${classNameLower}DTO) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}DTO));
		List<${className}DTO> list = null;
		try {
			
			//查询list
			 list = this.getForList(${classNameLower}DTO);
			
		} catch (Exception e) {
			logger.error("方法执行异常：["+e.getMessage()+"]",e);
		}
		logger.debug("输出参数：[{}]",JSONObject.toJSONString(list));
		return list;
	}
	
	@Override
	public ${className}DTO query${className}(${className}DTO ${classNameLower}DTO) {
		
		logger.debug("输入参数：[{}]",JSONObject.toJSONString(${classNameLower}DTO));
		${className}DTO result = null;
		try {
			
			//查询list
			List<${className}DTO> list = this.getForList(${classNameLower}DTO);
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
