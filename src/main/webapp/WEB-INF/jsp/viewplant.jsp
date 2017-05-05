<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>查询植物</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/head.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/footer.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
td{
width:20%
}

</style>
</head>
<body>
	<%@include file="/common/head.jsp"%>
	
	<div id="plantlist">
	
	
<table style="margin: 0px auto;width: 70%"class="table table-hover">
  <caption>植物列表</caption>
  <thead>
    <tr>
      <th>名称</th>
      <th>门</th>
      <th>科</th>
      <th>属</th>
      <th>更多</th>
    </tr>
  </thead>
  <tbody>
  <!-- var="每个变量名字"   items="要迭代的list"   varStatus="每个对象的状态" -->
    <c:forEach items="${plants}" var="plant" varStatus="status">
			<tr>
			<!-- 隐藏域 -->
				
				<td><input name="pid" type="hidden" value = "${plant.pid}"/>${plant.pname}</td>
				<td>${plant.phylum}</td>
				<td>${plant.pfamily}</td>
				<td>${plant.pgenus}</td>
				
				
				<td ><a style="color:#4D6CCE;" href="<%=request.getContextPath()%>/plant/detail?pid=${plant.pid}">查看详情</a>
				<a style="color:#4D6CCE;" href="<%=request.getContextPath()%>/plant/change?pid=${plant.pid}">修改</a></td>
			</tr>
		</c:forEach>
  </tbody>
</table>
	
		


	</div>


<%@include file="/common/footer.jsp"%>
</body>
</html>