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

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "v1/",produces = MediaType.APPLICATION_JSON_VALUE)
public class ${className}Controller {
	
	private final static Logger logger = LoggerFactory.getLogger(${className}Controller.class);
	//logger.error("method execute exception：["+e.getMessage()+"]",e);
	@Resource
	private ${className}Service  ${classNameLower}Service;
	
	 /**
     * 添加
     * @param ${classNameLower}
     * @return
     */
	@RequestMapping(value = "${classNameLower}" ,method = RequestMethod.POST)
	public ApiResponse add(@RequestBody @Valid ${className} ${classNameLower}) {
		
		logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
			
		${classNameLower}Service.add${className}(${classNameLower});

		return ApiResponse.successResponse();
	}

	/**
	 * 修改
	 * @param ${classNameLower}
	 * @return
	 */
	@RequestMapping(value = "${classNameLower}" ,method = RequestMethod.PUT)
	public ApiResponse update(@RequestBody ${className} ${classNameLower}) {

		logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));

		Long ${classNameLower}Id = ${classNameLower}.getId();
		Assert.notNull(${classNameLower}Id,"id输入参数不能为空.");

		${classNameLower}Service.modify${className}(${classNameLower});

		return ApiResponse.successResponse();
	}
	 /**
     * 修改 兼容标准REST
     * @param ${classNameLower}
     * @return
     */
	@RequestMapping(value = "${classNameLower}/{id}" ,method = RequestMethod.PUT)
	public ApiResponse updateWithPath(@RequestBody ${className} ${classNameLower},@PathVariable("id") ${pkColumn.javaType} id) {
		Long ${classNameLower}Id = ${classNameLower}.getId();
		if(${classNameLower}Id == null){
			${classNameLower}.setId(id);
		}
		return update(${classNameLower});
	}

	 /**
     * 删除 标准REST
     * @param id
     * @return
     */
	@RequestMapping(value = "${classNameLower}/{id}" ,method = RequestMethod.DELETE)
	public ApiResponse delete(@PathVariable("id") ${pkColumn.javaType} id){
		Assert.notNull(id,"id输入参数不能为空.");
		logger.debug("input parameters：[{}]",id);
		${classNameLower}Service.delete${className}(id);

		return  ApiResponse.successResponse();
	}
	
	 /**
     * 查询详情 标准REST
     * @param id
     * @return
     */
	@RequestMapping(value = "${classNameLower}/{id}" ,method = RequestMethod.GET)
	public ApiResponse get(@PathVariable("id") ${pkColumn.javaType} id) {
		Assert.notNull(id,"id输入参数不能为空.");
		logger.debug("input parameters：[{}]",id);
		
		${className} ${classNameLower} = null;

		${classNameLower} = ${classNameLower}Service.get${className}ById(id);

		logger.debug("output parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
		return ApiResponse.successResponse(${classNameLower});
	}

	 /**
     * 查询列表
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value = "${classNameLower}s" ,method = {RequestMethod.GET,RequestMethod.POST})
    public ApiResponse getList(${className} ${classNameLower}){
    	logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
    	List<${className}>  ${classNameLower}s = null;

    	${classNameLower}s = ${classNameLower}Service.query${className}s(${classNameLower});
			
		logger.debug("output parameters：[{}]",JSONObject.toJSONString(${classNameLower}s));
		return ApiResponse.successResponse(${classNameLower}s);
    }
    
    /**
     * 查询分页
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value = "${classNameLower}s" ,params ="pageNow",method = {RequestMethod.GET,RequestMethod.POST})
    public ApiResponse getPage(${className} ${classNameLower},@RequestParam("pageNow") Integer pageNow, @RequestParam("pageSize")Integer pageSize){
    	logger.debug("input parameters：[{}]",JSONObject.toJSONString(${classNameLower}));
    	DataGrid<${className}>  ${classNameLower}s = null;
    	if(pageSize == null || pageSize == 0){
    		pageSize = 10;
    	}
    	${classNameLower}s = ${classNameLower}Service.query${className}s(${classNameLower},pageNow,pageSize);

		logger.debug("output parameters：[{}]",JSONObject.toJSONString(${classNameLower}s));
		return ApiResponse.successResponse(${classNameLower}s);
    }
	/**
	 * 查询分页 历史兼容
	 */
	@RequestMapping(value = "${classNameLower}s" ,params ="pageNum",method = {RequestMethod.GET,RequestMethod.POST})
	public ApiResponse getPage1(${className} ${classNameLower},@RequestParam("pageNum") Integer pageNow, @RequestParam("pageSize")Integer pageSize){
		return getPage(${classNameLower},pageNow,pageSize);
	}

    	

}
