<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>首页</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/head.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/footer.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%@include file="/common/head.jsp"%>
	<!-- 基于主页的模板做 -->
	<div>

		<div style="margin: 0px auto; width: 70%; height: 800px">
			<form action="<%=request.getContextPath() %>/plant/changesubmit?pid=12">
				<table class="table">
					<caption>信息修改</caption>

					<thead>
						<tr>
							<th>名称</th>
							<td>
							<input name="pid" type="hidden" value = "${plant.pid}"/>
							<input name="pname" class="form-control" type="text"
								id="formGroupInputSmall" value="${plant.pname}"></td>
						</tr>
						<tr>
							<th>门</th>
							<td><input name="phylum" class="form-control" type="text"
								id="formGroupInputSmall" value="${plant.phylum}"></td>
						</tr>
						<tr>
							<th>科</th>
							<td><input name="pfamily" class="form-control" type="text"
								id="formGroupInputSmall" value="${plant.pfamily}"></td>
						</tr>
						<tr>
							<th>属</th>
							<td><input name="pgenus" class="form-control" type="text"
								id="formGroupInputSmall" value="${plant.pgenus}"></td>
						</tr>
						<tr style="border-bottom: 1px solid #DDDDDD">
							<th>描述</th>
							<td><textarea name="pdesc" class="form-control" rows="5"
									>${plant.pdesc}</textarea></td>
						</tr>
						<tr>
							<th>图片</th>
							<td><input name="pphotos" class="form-control" type="text"
								id="formGroupInputSmall" value="${plant.pphotos}"></td>
						</tr>
						
					</thead>

				</table>
			 <input type="submit" value="提交">
			</form>

		</div>

	</div>


	<%@include file="/common/footer.jsp"%>
</body>
</html>



