layui.use([ 'element', 'jquery','layer' ], function() {
	var element = layui.element;
	var $ = layui.jquery;
	element.on('nav(leftNav)', function(elem) {
		console.log(elem.attr('data-url'));
		
		//-- 方式一： $('#content').html('<p>hello world</p>');
		//-- 方式二： $('#content').load(elem.attr('data-url'));
		//-- 方式三： 加回调函数，处理错误信息
		$('#content').load(elem.attr('data-url'),function (responseText, textStatus, XMLHttpRequest){         
	        //-- alert(responseText);         //请求返回的内容
	        //-- alert(textStatus);          //请求状态：success，error
	        //-- alert(XMLHttpRequest);     //XMLHttpRequest对象
			if(textStatus === 'error'){
				//-- alert(XMLHttpRequest.status);
				//-- $(this).html('访问错误');  //-- 可以根据错误码进行细节处理
				//layer.msg('访问错误');
				$(this).html('<div class="layui-elem-quote"><p>温馨提示 - 访问出错啦，请稍后重试...错误码['+XMLHttpRequest.status+']</p></div>');
			}
		});
	});
});