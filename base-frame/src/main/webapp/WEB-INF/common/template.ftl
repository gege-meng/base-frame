<#assign base=request.contextPath />
<#macro htmlHead title charset="utf-8" lang="zh-CN">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=${charset}" />
    <meta http-equiv="Content-Language" content="${lang}"/>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="${base}/css/style.css">
    <#nested>
</head>
<body>
</#macro>
 
<#macro htmlBody>
	<#if user??>
	<div class="header"> 
		<div class="nav">
			<span>当前登录用户：<strong> <#if user??>${user.name}</#if> </strong><span>
			<span><small> <a href="/loginout">退出</a> </small><span>
		</div>
	</div>
    
	<div class="container">
		 <#nested>
	</div>
	</#if>
</#macro>
 
<#macro htmlFooter>
</body>
<script src="${base}/js/lib/jquery.js" type="text/javascript"></script>
<script src="${base}/js/lib/layer.js" type="text/javascript"></script>
<#nested>
</html>
</#macro>
 
<#--
<!DOCTYPE html>  
<html lang="en">  
<head>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>  
	<div class="header"> 
		<div class="nav">
			<span>当前登录用户：<strong> <#if user??>${user.name}</#if> </strong><span>
			<span><small> <a href="/loginout">退出</a> </small><span>
		</div>
	</div>
	
	<div class="container">
		 <#if user??>${user.name}</#if>
	</div>
</body> 
<script src="/js/lib/jquery.js" type="text/javascript"></script>
<script type="text/javascript">  
</script>
</html>-->





