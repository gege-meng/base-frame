$('.form .submit').click(function() {
	var number_ = $('.form input[name=number]').val();
	var name_ = $('.form input[name=name]').val();
	if (number_ != undefined && name_ != undefined) {
		$.post("/login", {
			number : number_,
			name : name_
		}, function(data) {
			alert(data); // 
			console.log(data);
		}).success(function(data) {
			location.href = '?' + $('form').serialize();
		}).error(function(data) {
			// alert(data+"complete");
		});
	}else {
		alert('账号和用户名不能为空');
    }
});