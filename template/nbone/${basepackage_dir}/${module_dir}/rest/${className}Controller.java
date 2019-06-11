<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
<#assign pkColumn = table.pkColumn> 
<#assign pkType = table.pkColumn.javaType> 

package ${basepackage}.${module}.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import org.nbone.common.model.DataGrid;
import org.nbone.mvc.rest.ApiResponse;
import ${basepackage}.${module}.domain.${className};
import ${basepackage}.${module}.service.${className}Service;

/**
 * <p>[描述该类概要功能介绍]</p>
 * @author ${author}
 * @since  ${currentDate}
 * @version ${version}
 * Copyright (c) ${copyright}
 */
@RestController
@RequestMapping("v1/")
public class ${className}Controller {
	
	private final static Logger logger = LoggerFactory.getLogger(${className}Controller.class);
	
	@Resource
	private ${className}Service  ${classNameLower}Service;
	
	 /**
     * 添加
     * @param ${classNameLower}
     * @return
     */
	@RequestMapping(value = "${classNameLower}" ,method = RequestMethod.POST)
	public ApiResponse add(@Valid ${className} ${classNameLower}) {
		
		logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
		try {
			
			 ${classNameLower}Service.add${className}(${classNameLower});
		} catch (Exception e) {
			logger.error("method execute exception：["+e.getMessage()+"]",e);
			return ApiResponse.errorResponse(e.getMessage());
		}
		
		return ApiResponse.successResponse();
	}
	
	 /**
     * 修改
     * @param ${classNameLower}
     * @return
     */
	@RequestMapping(value = "${classNameLower}/{id}" ,method = RequestMethod.PUT)
	public ApiResponse update(${className} ${classNameLower}) {
		
		logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
		try {
			
			${classNameLower}Service.modify${className}(${classNameLower});
		} catch (Exception e) {
			logger.error("method execute exception：["+e.getMessage()+"]",e);
			return ApiResponse.errorResponse(e.getMessage());
		}
		
		return ApiResponse.successResponse();
	}

	 /**
     * 删除
     * @param id
     * @return
     */
	@RequestMapping(value = "${classNameLower}/{id}" ,method = RequestMethod.DELETE)
	public ApiResponse delete(@PathVariable("id") ${pkColumn.javaType} id){
		Assert.notNull(id,"id输入参数不能为空.");
		logger.debug("input parameters：[{}]",id);
		try {
			${classNameLower}Service.delete${className}(id);
			
		} catch (Exception e) {
			logger.error("method execute exception：["+e.getMessage()+"]",e);
			return ApiResponse.errorResponse(e.getMessage());
		}
		return  ApiResponse.successResponse();
	}
	
	 /**
     * 查询详情
     * @param id
     * @return
     */
	@RequestMapping(value = "${classNameLower}/{id}" ,method = RequestMethod.GET)
	public ApiResponse get(@PathVariable("id") ${pkColumn.javaType} id) {
		Assert.notNull(id,"id输入参数不能为空.");
		logger.debug("input parameters：[{}]",id);
		
		${className} ${classNameLower} = null;
		try {
			
			${classNameLower} = ${classNameLower}Service.get${className}ById(id);
			
		} catch (Exception e) {
			logger.error("method execute exception：["+e.getMessage()+"]",e);
			return ApiResponse.errorResponse(e.getMessage());
		}
		logger.debug("output parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
		return ApiResponse.successResponse(${classNameLower});
	}
	
	 /**
     * 查询列表
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value = "${classNameLower}" ,method = RequestMethod.GET)
    public ApiResponse getList(${className} ${classNameLower}){
    		logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
    		 List<${className}>  ${classNameLower}s = null;
		try {
			
			${classNameLower}s = ${classNameLower}Service.query${className}s(${classNameLower});
			
		} catch (Exception e) {
			logger.error("method execute exception：["+e.getMessage()+"]",e);
			return ApiResponse.errorResponse(e.getMessage());
		}
		logger.debug("output parameters：[{}]",JSONObject.toJSONString(${classNameLower}s));
		return ApiResponse.successResponse(${classNameLower}s);
    }
    
    /**
     * 查询分页
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value = "${classNameLower}" ,params ="pageNow",method = RequestMethod.GET)
    public ApiResponse getPage(${className} ${classNameLower},@RequestParam("pageNow") Integer pageNow, @RequestParam("pageSize")Integer pageSize){
    		logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
    		DataGrid<${className}>  ${classNameLower}s = null;
    		if(pageSize == null || pageSize == 0){
    	            pageSize = 10;
    	    }
		try {
			
			${classNameLower}s = ${classNameLower}Service.query${className}s(${classNameLower},pageNow,pageSize);
			
		} catch (Exception e) {
			logger.error("method execute exception：["+e.getMessage()+"]",e);
			return ApiResponse.errorResponse(e.getMessage());
		}
		logger.debug("output parameters：[{}]",JSONObject.toJSONString(${classNameLower}s));
		return ApiResponse.successResponse(${classNameLower}s);
    }
    	

}
