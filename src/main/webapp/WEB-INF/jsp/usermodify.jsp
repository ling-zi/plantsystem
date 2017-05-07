<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/head.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/footer.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@include file="/common/head.jsp"%>

<div>

<div style="margin:0px auto; width:70%;height:800px">

<form action="<%=request.getContextPath() %>/login/domodify?uid=${user.uid}">
				<table style="width:400px" class="table">
					<caption>个人信息修改</caption>

					<thead>
						<tr>
							<th>用户名</th>
							<td>
							<input name="uid" type="hidden" value = "${user.uid}"/>
							<input name="uname" class="form-control" type="text"
								id="formGroupInputSmall" value="${user.uname}"></td>
						</tr>
						<tr>
							<th>性别</th>
							<td><input type=radio name="usexy" class="form-control" type="text"
								id="formGroupInputSmall" value="male">男
								<input type=radio name="usexy" class="form-control" type="text"
								id="formGroupInputSmall" value="female">女
								</td>
						</tr>
						<tr>
							<th>头像</th>
							<td><input name="uimageurl" class="form-control" type="text"
								id="formGroupInputSmall" value="${user.uimageurl}"></td>
						</tr>
						<tr>
							<th>邮箱</th>
							<td><input name="uemail" class="form-control" type="text"
								id="formGroupInputSmall" value="${user.uemail}"></td>
						</tr>
						<tr>
							<th>手机</th>
							<td><input name="ucellphone" class="form-control" type="text"
								id="formGroupInputSmall" value="${user.ucellphone}"></td>
						</tr>
						<tr style="border-bottom: 1px solid #DDDDDD">
							<th>地址</th>
							<td><textarea name="uaddress" class="form-control" rows="5"
									>${user.uaddress}</textarea></td>
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



