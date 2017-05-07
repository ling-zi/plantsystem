<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/register.js"></script>
<style type="text/css">
#div00 {
	
}

#div01 {
	background: url(<%=request.getContextPath() %>/image/timg.jpg);
	height: 650px;
	width: 100%;
}

#div02 {
	position: absolute;
	left: 38%;
	top: 30%;
	width: 400px;
	height: 320px;
	background-color: white;
	opacity: 0.55;
	filter: Alpha(opacity = 55);
	border-radius: 3px;
}

#div03 {
	position: absolute;
	left: 15%;
	top: 25%;
	width: 500px;
}

#login_div {
	width: 280px;
	height: 260px;
	background-color: white;
	margin: 0 auto;
}

#login_span {
	text-align: center;
}

#switch_line {
	position: absolute;
	top: 69px;
	left: 120px;
	border-bottom: 2px solid #64809F;
	width: 60px;
}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>

<script>
	$(function() {
		/* 切换登录事件*/
		$("#login_switch").click(function() {
			$("#regist_switch").parent().removeClass("active");
			$("#login_switch").parent().addClass("active");
			$("#switch_line").animate({
				left : '120px'
			}); //下滑线
			$('#login_input_div').show();
			$('#register_input_div').hide();
		});
		/* 切换注册事件*/
		$("#regist_switch").click(function() {
			$("#login_switch").parent().removeClass("active");
			$("#regist_switch").parent().addClass("active");
			$("#switch_line").animate({
				left : '210px'
			}); //下滑线
			$('#register_input_div').show();
			$('#login_input_div').hide();
		});
	})
</script>

</head>

<body>
	<div id="div00">
		<!--
        	作者：944909417@qq.com
        	时间：2017-04-28
        	描述：导航
        -->
		<div>
			<div class="page-header"
				style="width: 90%; margin: 0 auto; height: 120px;">
				<img style="width: 300px; height: 120px;" src="<%=request.getContextPath()%>/image/logo.png" />
			</div>
		</div>


		<div id="div01">
			<div id="div03" name="left"></div>
			<div id="div02" name="right">
				<div id="login_div">
					<div id="switch_div"
						style="margin-top: 20px; margin-bottom: 10px; border-bottom: 1px solid #64809F;">

						<ul class="nav nav-pills"
							style="margin: 0 auto; margin-bottom: 10px;">
							<li role="presentation" class="active" style="left: 60px;">
								<a id="login_switch" href="javascript:void(0)">登录</a>
							</li>
							<li role="presentation" class="" style="left: 90px;"><a
								id="regist_switch" href="javascript:void(0)">注册</a></li>
						</ul>

					</div>
					<div class="switch_bottom" id="switch_line"></div>
					<!--
                        	作者：944909417@qq.com
                        	时间：2017-04-28
                        	描述：登录信息输入框
                        -->
					<div style="height: 10px;"></div>
					<form action="<%=request.getContextPath()%>/login"
						method="post">
						<div id="login_input_div">
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">邮箱&nbsp;&nbsp;&nbsp;</span>
								<input name="username" type="text" class="form-control"
									placeholder="请输入邮箱" aria-describedby="basic-addon1">
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">密码&nbsp;&nbsp;&nbsp;</span>
								<input name="password" type="password" class="form-control"
									placeholder="请输入密码" aria-describedby="basic-addon1">
							</div>
							<br /> <br /> <br /> <span class="input-group-btn"
								id="login_span">
								<button class="btn btn-default" type="submit">登录</button>
							</span>
						</div>
					</form>
					<!--
                        	作者：944909417@qq.com
                        	时间：2017-04-28
                        	描述：注册信息输入框
                        -->
					<form action="<%=request.getContextPath()%>/login/register"
						method="post">
						<div id="register_input_div" style="display: none;">
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">用户名</span> <input
									name="r_username" type="text" class="form-control"
									placeholder="请设置用户名" aria-describedby="basic-addon1">
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">密码&nbsp;&nbsp;&nbsp;</span>
								<input name="r_password" type="password" class="form-control"
									placeholder="请设置登录密码" aria-describedby="basic-addon1">
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">邮箱&nbsp;&nbsp;&nbsp;</span>
								<input name="r_email" type="text" class="form-control"
									placeholder="可用于登录" aria-describedby="basic-addon1"
									onblur="checkemail()" />

							</div>
							<div id="emailtip">
								<span> </span>
							</div>
							<br /> <span class="input-group-btn" id="login_span">
								<button class="btn btn-default" type="submit">注册</button>
							</span>
						</div>
					</form>
					<div id=""></div>

				</div>
			</div>
		</div>

	</div>
	<!--
        	作者：944909417@qq.com
        	时间：2017-04-28
        	描述：顶部+版权
        -->
	<div style="text-align: center; margin-top: 50px;">

		<h4 style="font-weight: bold;">Copyright © 2017.Huashi All
			rights reserved 花事未了</h4>
	</div>
	</div>
</body>

</html>