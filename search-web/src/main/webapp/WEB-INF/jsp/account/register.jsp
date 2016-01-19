<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="../common/base.jsp" flush="true"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=basePath%>images/favicon.png">
    <title>用户注册</title>
</head>

<body class="texture">

<div id="cl-wrapper" class="sign-up-container">

    <div class="middle-sign-up">
        <div class="block-flat">
            <div class="header">
                <h3 class="text-center"><img class="logo-img" src="<%=basePath%>images/logo.png" alt="logo"/> 管理系统
                </h3>
            </div>
            <div>
                <form id="register-form" style="margin-bottom: 0px !important;" class="form-horizontal"
                      action="javascript:;">
                    <div class="content">
                        <h4 class="title">注册新用户</h4>
                        <hr/>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input type="text" name="nickname" class="form-control" placeholder="请填写昵称"
                                           data-parsley-required="false"
                                           data-parsley-trigger="change"
                                           data-parsley-maxlength="25"
                                           data-parsley-errors-container="#nickname-error"
                                    >
                                </div>
                                <div id="nickname-error"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                    <input type="email" name="username" id="username" class="form-control"
                                           placeholder="E-mail"
                                           data-parsley-required="true"
                                           data-parsley-trigger="change"
                                           data-parsley-type="email"
                                           data-parsley-maxlength="25"
                                           data-parsley-errors-container="#username-error"
                                    >
                                </div>
                                <div id="username-error"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input id="password" name="password" type="password" class="form-control" placeholder="密码"
                                           data-parsley-required="true"
                                           data-parsley-trigger="change"
                                           data-parsley-errors-container="#password-error"
                                           data-parsley-length="[6, 16]">
                                </div>
                                <div id="password-error"></div>
                            </div>

                            <div class="col-sm-6 col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="password" name="confirmPassword" placeholder="确认密码" class="form-control"
                                           data-parsley-required="true"
                                           data-parsley-equalto="#password"
                                           data-parsley-errors-container="#confirmation-error">
                                </div>
                                <div id="confirmation-error"></div>
                            </div>
                        </div>
                        <p class="spacer">阅读并接受 <a href="#">注册协议</a> 和 <a href="#">用户条款</a>.</p>
                        <button class="btn btn-block btn-success btn-rad btn-lg" type="submit">注册</button>

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

<script type="text/javascript" src="<%=basePath%>js/system/account/register.js"></script>
</body>
</html>
