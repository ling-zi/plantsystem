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
<div name="showcomments">

<table class="table">
  <caption>用户评论</caption>
  <thead>
    <tr>
      <th>用户</th>
      <th>留言板</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>小明</td>
      <td>这个苹果很好吃</td>
    </tr>
    <tr>
      <td>小狗</td>
      <td>图片有误</td>
    </tr>
  </tbody>
</table>



</div>
<div name="comment">
<form action="">
<tr style="border-bottom: 1px solid #DDDDDD">
							<th>留言</th>
							<td><textarea name="pdesc" class="form-control" rows="5"
									>请输入您的留言</textarea></td>
</tr>

<!-- 留言展示 -->

<br />
<button type="submit" class="btn btn-default">发表</button>
</form>

</div>
</div>

</div>


<%@include file="/common/footer.jsp"%>
</body>
</html>