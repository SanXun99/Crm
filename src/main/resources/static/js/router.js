$(function(){

  $('.layui-nav-child').on({
    click:function(){
      if($(this).text().trim()=="商机开发计划"){
        $('.layui-body').load('pages/plan.html');
       
      }
       if($(this).text().trim()=="销售商机管理"){
        $('.layui-body').load('toSales');
        
      }
       if($(this).text().trim()=="客户信息查询"){
        $('.layui-body').load('pages/customer.html');
        
      }
      // if($(this).text()=="客户信息添加"){
      //   $('.layui-body').load('./pages/customer_add.html');
       
      // }
      if($(this).text().trim()=="服务反馈"){
        $('.layui-body').load('pages/feedback.html');
        
      }
      if($(this).text().trim()=="服务处理"){
        $('.layui-body').load('pages/service.html');
       
      }
      if($(this).text().trim()=="客户贡献分析"){
        $('.layui-body').load('pages/customerContribution.html');
       
      }
       if($(this).text().trim()=="客户构成分析"){
        $('.layui-body').load('toCustomerConstitute');
        
      }
       if($(this).text().trim()=="角色管理"){
        $('.layui-body').load('toRole');
        
      }
       if($(this).text().trim()=="用户管理"){
        $('.layui-body').load('toUser');
       
      }
      
    }
  },'dd');
});




