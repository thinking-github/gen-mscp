package com.camelot.test.client.service;
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import  ${basepackage}.${classNameLower}.dto.${className}DTO;
import com.camelot.test.client.BaseTest;

/**
 *  ${className}-client单元测试
 * 
 * @Description -
 * @author - 
 * @createDate - 
 */
public class ${className}ServiceClientImplTest_AllTest extends BaseTest{

	@Before
	public void setUp() throws Exception {
	}

	@Test  
	public void testMyApi() {
		try {
			${className}DTO ${classNameLower}DTO=${classNameLower}ServiceClient.get${className}ById(1l);
			System.out.println(${classNameLower}DTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail("Test failed!");
		}
	}

	@Ignore
	public void testOtherSpringObject() {
		fail("Not yet implemented");
	}
}
