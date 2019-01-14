//-- 这里注意thymeleaf与layui冲突的问题："[["是thymeleaf的表达式，所以定义二维数组的时候须换行定义二维数组，例如：
/*
	[
		[
			
		]
	]
这样定义即可。
 */
var getUsers = function(){
	layui.use('table', function() {
		var table = layui.table;
		var cols = table.render({
			elem: '#demo',
			url: 'user/list',
			toolbar: 'default',
			page: true,
			cols : [ [
				 {field: 'id', title: 'ID', width:50, fixed: 'left'},
				 {field: 'username', title: '用户名', width:200},
			     {field: 'password', title: '密码', width:80},
			     {field: 'createTime', title: '创建时间', templet: "<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"},
			     {field: 'updateTime', title: '更新时间', templet: "<div>{{layui.util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"},
			] ]
		});
	});
}
