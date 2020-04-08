layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
layui.use('layer', function(){
      var layer = layui.layer;
      $(document).on('click','#nine',function(){
		        layer.confirm('确定要提交？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
		  layer.msg('提交成功', {icon: 1});
		}, function(){
		  layer.msg('继续填写信息', {
		    time: 2000, 
		    btn: ['明白了']
		  });
		});
		       });
    });     