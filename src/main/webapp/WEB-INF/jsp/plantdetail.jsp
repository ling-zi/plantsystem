<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/head.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/footer.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
    th{width:20%}
    
    
    </style>
    
    
</head>
<body>
<%@include file="/common/head.jsp"%>
<!-- 基于主页的模板做 -->
<div>

<div style="margin:0px auto; width:70%;height:800px">

<table class="table">
  <caption>植物详情</caption>
  <thead>
    <tr>
      <th>名称</th>
      <td>${plant.pname}</td>
    </tr>
    <tr>
      <th>门</th>
      <td>${plant.phylum}</td>
    </tr>
    <tr>
      <th>科</th>
      <td>${plant.pfamily}</td>
    </tr>
    <tr>
      <th>属</th>
      <td>${plant.pgenus}</td>
    </tr>
    <tr style="border-bottom: 1px solid #DDDDDD">
      <th>描述</th>
     <td>${plant.pdesc}</td>
    </tr >
  </thead>
 
</table>

</div>

</div>


<%@include file="/common/footer.jsp"%>
</body>
</html>