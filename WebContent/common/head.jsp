<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/head.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/footer.css"/>
		
	</head>

	<body>
		<!--
        	作者：944909417@qq.com
        	时间：2017-05-02
        	描述：头部
        -->
		<div id="div00">
			<div class="page-header" style="width: 90%;margin: 0 auto; height: 120px;">
				<img style=" width: 300px;height: 120px;" src="<%=request.getContextPath() %>/image/logo.png" />
				<form class="navbar-form navbar-right">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Search">
									</div>
									<button type="submit" class="btn btn-default">搜索</button>
								</form>
			</div>

			<!--
                	作者：944909417@qq.com
                	时间：2017-05-02
                	描述：导航条
                -->
			<div id="navigation01">
				<div id="nav_content">
					<dl class="nav_dl">
						<dt class="nav_dt">
							<a href="/">首页</a>
						</dt>
						
					</dl>
					<dl class="nav_dl">
						<dt class="nav_dt"><a href="/">分类</a></dt>
						
					</dl>
					<dl class="nav_dl">
						<dt class="nav_dt"><a href="/">特色百科</a></dt>
						
					</dl>

					<div id="usercenter" >
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						<a href="<%= request.getContextPath()%>/myLogin?type=index">个人中心</a>
					</div>
					
				</div>

			</div>

		</div>


