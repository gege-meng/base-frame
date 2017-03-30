$('.form .submit').click(function() {
	var number_ = $('.form input[name=number]').val();
	var name_ = $('.form input[name=name]').val();
	if (number_ != "" && name_ != "") {
		$.post("/login", {
			number : number_,
			name : name_
		}, function(data) {
			console.log(data.msg);
			if(data.code==100){
				location.href = '/user/list';
			}else{
				alert(data.msg); 
			}
		});
	}else {
		layer.msg('账号和用户名不能为空');
//		alert('账号和用户名不能为空');
    }
});