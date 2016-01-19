<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="../common/base.jsp" flush="true"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=basePath%>static/images/favicon.png">
    <title>系统登录</title>
</head>
<body class="texture">
<div id="cl-wrapper" class="login-container">
    <div class="middle-login">
        <div class="block-flat">
            <div class="header">
                <h3 class="text-center">
                    <img class="logo-img" src="<%=basePath%>images/logo.png" alt="logo"/>管理系统
                </h3>
            </div>
            <div>
                <form id="login-form" style="margin-bottom: 0px !important;" class="form-horizontal"
                      action="javascript:;">
                    <div class="content">
                        <h4 class="title">用户登录</h4>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input type="text" id="username" name="username" class="form-control"
                                           placeholder="请填写用户名"
                                           data-parsley-type="email"
                                           data-parsley-trigger="change"
                                           data-parsley-errors-container="#username-error"
                                           data-parsley-required="true">
                                </div>
                                <div id="username-error"></div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="password" id="password" name="password" class="form-control"
                                           placeholder="请填写密码" data-parsley-required="true"
                                           data-parsley-trigger="change"
                                           data-parsley-errors-container="#password-error"
                                           data-parsley-length="[6, 16]">
                                </div>
                                <div id="password-error"></div>
                            </div>
                        </div>
                    </div>
                    <div class="foot">
                        <button class="btn btn-default" data-dismiss="modal" type="button" id="register-btn">注册</button>
                        <button class="btn btn-primary" data-dismiss="modal" type="submit">登录</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="text-center out-links"><a href="#">&copy; 2015 码农工作室</a></div>
    </div>
</div>

<!--parsley表单验证-->
<script type="text/javascript" src="<%=basePath%>js/jquery.parsley/parsley.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.parsley/i18n/zh_cn.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/account/login.js"></script>
</body>
</html>
