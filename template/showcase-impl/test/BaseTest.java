<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>  
<#assign classNameLower = className?uncap_first>
	@Resource
	protected ${className}ServiceClient ${classNameLower}ServiceClient;
