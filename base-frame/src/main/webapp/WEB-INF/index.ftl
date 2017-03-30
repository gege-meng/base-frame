<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="header">
		
	</div>
	<div class="container">
	    <div class="form">
			<dl>
				<dt>用户编码</dt>
				<dd><input type="text" name="number" placeholder="用户编码"/></dd>
			</dl>
			<dl>
				<dt>用户名称</dt>
				<dd><input type="text" name="name" placeholder="用户名称"/></dd>
			</dl>
			
			${result!''}
			<div class="btn-group">
				<input type="button" class="btn-default submit" value="登录"/>
			</div>
		</div>
	</div>
</body>
<script src="/js/lib/jquery.js" type="text/javascript"></script>
<script src="/js/lib/layer.js" type="text/javascript"></script>
<script src="/js/index.js" type="text/javascript"></script>
</html>



