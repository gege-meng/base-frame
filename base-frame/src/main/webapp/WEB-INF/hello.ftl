<!DOCTYPE html>  
<html lang="en">  
<head>
	<script src="js/jquery.js" type="text/javascript"></script>
	<style type="text/css">
		body{font-family: 'Microsoft YaHei'; font-family: Arial,'Times New Roman','Microsoft YaHei',SimHei;}
	</style>
</head>
<body> 
	<#-- 定时器  start --> 
	<div class="jf_register">  
	    <h2>您好，欢迎光临<fmt:message key="b2cShowName"/>！<a class="blue" href="<%=path%>/LoginRegist_turnToLogin">请登录</a></h2>  
	</div>  
	<div class="jf_register_banner">注册成功</div>  
	<div class="jf_password">  
		<ul>  
		<li> 感谢您选择<fmt:message key="b2cShowName"/>，</li><li>您的账号<span>  
		<font color=red><strong>小米</strong></font></span>已经注册成功。 </li>  
		<li>系统将会在<strong id="endtime"></strong>秒后跳转到登录页！  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
		<a class="blue" href="/user/list">直接登录</a></li>  
		</ul>  
	</div>  
	<div class="jf_loginfooter"><fmt:message key="copyright"/>&nbsp;版权所有&nbsp;|   
	<a href="Login_loginHelpTips">联系我们</a><fmt:message key="copyrightIcp"/></div>  
	<#-- 定时器  end --> 
	
	<#-- 定时器 JS start --> 
	<script type="text/javascript">  
		var i = 10;  
		function remainTime(){  
		    if(i==0){  
		        location.href='/user/list';  
		    }  
		    document.getElementById('endtime').innerHTML=i--;  
		    setTimeout("remainTime()",1000);  
		}  
		remainTime();  
	</script> 
	<#-- 定时器 JS end --> 
</body>  
</html>
