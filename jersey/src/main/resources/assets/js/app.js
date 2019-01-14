layui.use([ 'element', 'jquery' ], function() {
	var element = layui.element;
	var $ = layui.jquery;
	element.on('nav(leftNav)', function(elem) {
		console.log(elem.attr('data-url'));
		// -- $('#content').html('<p>hello world</p>');
		$('#content').load(elem.attr('data-url'));
	});
});