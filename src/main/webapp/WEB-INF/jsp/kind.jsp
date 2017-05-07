<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>首页</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/head.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/footer.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
li {
	width: 90px;
	background-color: #9D3662;
}
</style>


<script type="text/javascript">
	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "<%=request.getContextPath()%>/plant", true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<%@include file="/common/head.jsp"%>
	<!-- 植物分类信息 -->
	<div>

		<div style="margin: 0px auto; width: 70%; height: 800px">
			<div style="margin-left: 40px">
				<ul class="nav nav-pills nav-stacked">
				
					<li role="presentation" class=""><a href="<%=request.getContextPath()%>/plant">被子植物</a></li>
					<li role="presentation" class=""><a href="#">裸子植物</a></li>
					<li role="presentation" class=""><a href="#">蕨类植物</a></li>
					<li role="presentation" class=""><a href="#">苔藓植物</a></li>
					<li role="presentation" class=""><a href="#">地衣</a></li>
					<li role="presentation" class=""><a href="#">裸藻</a></li>
					<li role="presentation" class=""><a href="#">绿藻</a></li>
					<li role="presentation" class=""><a href="#">轮藻</a></li>
					<li role="presentation" class=""><a href="#">金藻</a></li>
					<li role="presentation" class=""><a href="#">蓝藻</a></li>
					<li role="presentation" class=""><a href="#">真菌</a></li>
					<li role="presentation" class=""><a href="#">粘菌</a></li>
					<li role="presentation" class=""><a href="#">细菌</a></li>
				</ul>

			</div>



		</div>

	</div>


	<%@include file="/common/footer.jsp"%>
</body>
</html>



