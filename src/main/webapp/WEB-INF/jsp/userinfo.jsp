<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/head.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/footer.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@include file="/common/head.jsp"%>
<!-- 显示用户个人信息界面 -->
<div>

<div style="margin:0px auto; width:70%;height:800px">
<form action="<%=request.getContextPath() %>/login/modify?uid=${user.uid}">
<table class="table">
  <caption>个人信息</caption>
  <thead>
    <tr>
    
      <th>用户名</th>
      <!-- 隐藏域 -->
      <td><input name="uid" type="hidden" value = "${user.uid}"/>${user.uname}</td>
    </tr>
     <tr>
      <th>头像</th>
      <td>${user.uname}</td>
    </tr>
    <tr>
      <th>邮箱</th>
      <td>${user.uemail}</td>
    </tr>
    <tr>
      <th>手机号</th>
      <td>${user.ucellphone}</td>
    </tr>
    <tr>
    <tr>
      <th>性别</th>
      <td>${user.usexy}</td>
    </tr>
    <tr style="border-bottom: 1px solid #DDDDDD">
      <th>通讯地址</th>
      <td>${user.uaddress}</td>
    </tr >
  </thead>
  
</table>

<input type="submit" value="编辑个人资料">
</form>
</div>

</div>


<%@include file="/common/footer.jsp"%>
</body>
</html>



