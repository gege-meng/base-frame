<!DOCTYPE html>  
<html lang="en">  
<head>
	<style type="text/css">
		body{font-family: 'Microsoft YaHei'; font-family: Arial,'Times New Roman','Microsoft YaHei',SimHei;}
		
	</style>
</head>
<body>  
	<h1>list</h1>
	<div class=""> 
		<!--<img class="" src="/img/zi.jpg" alt="到百度首页" title="到百度首页">-->
	</div>
	<table>
		<#list datas as data>
		    <tr>
		        <td>${data.name}</td>
		        <td>${data.lastupdateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		    </tr>
		</#list>
	</table>
	<a id="name" href="/user/add">新增</a>
</body>  
</html>
