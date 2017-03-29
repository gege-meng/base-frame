<!DOCTYPE html>  
<html lang="en">  
<head>
	<style type="text/css">
		body{font-family: 'Microsoft YaHei'; font-family: Arial,'Times New Roman','Microsoft YaHei',SimHei;}
	</style>
</head>
<body>  
	<h1>list</h1>
	<table>
		<#list datas as data>
		    <tr>
		        <td>${data.name}</td>
		        <td>${data.state}</td>
		        <td>${data.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		        <td><a id="name" href="/bigsubject/start/${data.id}" text="${data.id}">开始作答</a></td>
		    </tr>
		</#list>
	</table>
	<a id="name" href="/bigsubject/add">新增</a>
	
	<script src="/js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
		alert($('#name').attr('text'));
	</script>
</body>  
</html>

