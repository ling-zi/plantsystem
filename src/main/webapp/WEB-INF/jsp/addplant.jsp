<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addPlant</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/head.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/footer.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@include file="/common/head.jsp"%>
<div id="main_content">
    <div id="main_content01">
        <div>
            <form action="<%=request.getContextPath() %>/plant/addplant" method="post" enctype="multipart/form-data"  class="form-horizontal">
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label" for="formGroupInputSmall">名称:</label>
                    <div class="col-sm-2">
                        <input class="form-control" type="text" id="formGroupInputSmall"
                               name="pname" placeholder="请输入植物名称">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label" for="formGroupInputSmall">门:</label>
                    <div class="col-sm-2">
                        <input name="phylum" class="form-control" type="text" id="formGroupInputSmall"
                               placeholder="请输入植物门">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label" for="formGroupInputSmall">科:</label>
                    <div class="col-sm-2">
                        <input name="pfamily" class="form-control" type="text" id="formGroupInputSmall"
                               placeholder="请输入植物科">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label" for="formGroupInputSmall">属:</label>
                    <div class="col-sm-2">
                        <input name="pgenus" class="form-control" type="text" id="formGroupInputSmall"
                               placeholder="请输入植物属">
                    </div>
                </div>

                <!-- 描述 -->
                <div style="margin-left:210px">

                    <div class="form-group">
                            <textarea name="pdesc" style="width:700px;" class="form-control" rows="5"
                                      placeholder="请输入植物描述"></textarea>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label" for="formGroupInputSmall">图片</label>
                    <div class="col-sm-2">
                        <input name="file" class="form-control" type="file">
                    </div>
                </div>
                <input type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>