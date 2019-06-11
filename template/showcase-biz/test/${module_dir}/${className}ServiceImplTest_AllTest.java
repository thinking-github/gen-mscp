<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first> 
package ${basepackage_dir}.test.biz.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ${basepackage}.${module}.domain.${className};
import com.camelot.test.biz.BaseTest;



public class ${className}ServiceImplTest_AllTest extends BaseTest{

	@Before
	public void setUp() throws Exception {
	}

	@Test  
	public void testMyApi() {
		try {
			${className} ${classNameLower}=${classNameLower}Service.find${className}ById(1l);
			System.out.println(${classNameLower});
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
