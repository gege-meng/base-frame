<#include "/common/template.ftl"/>
<@htmlHead title="首页"><#-- 自定的 css --></@htmlHead>
<@htmlBody>
	<table>
		<#list datas as data>
		    <tr>
		        <td>${data.name}</td>
		        <td>${data.lastupdateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		    </tr>
		</#list>
	</table>
	<a id="name" href="/user/add">新增</a>
</@htmlBody>
<@htmlFooter><#-- 自定义的js --></@htmlFooter>

