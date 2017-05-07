 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="div00">
    <div class="page-header" style="width: 90%;margin: 0 auto; height: 120px;">
        <img style=" width: 300px;height: 120px;" src="<%=request.getContextPath() %>/image/logo.png"/>
        <form action="<%=request.getContextPath() %>/plant/search" method="post" class="navbar-form navbar-right">
            <div class="form-group">
                <input name="pname" type="text" class="form-control" placeholder="请输入植物名称">
            </div>
            <button type="submit" class="btn btn-default">search</button>
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
                    <a href="<%=request.getContextPath() %>/index">首页</a>
                </dt>

            </dl>
            <dl class="nav_dl">
                <dt class="nav_dt">
                	<a href="<%=request.getContextPath() %>/kind">分类</a></dt>

            </dl>
            <dl class="nav_dl">
                <dt class="nav_dt"><a href="/">特色百科</a></dt>

            </dl>

            <div id="usercenter">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <a href="<%= request.getContextPath()%>/login/login_register">个人中心</a>
            </div>

        </div>

    </div>

</div>
