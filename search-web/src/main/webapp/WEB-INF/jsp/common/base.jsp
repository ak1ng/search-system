<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>后台主页</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>fonts/font-awesome-4/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath%>js/toastr/toastr.min.css" rel="stylesheet"/>
    <!-- Custom styles for this templates -->
    <link href="<%=basePath%>css/style.css" rel="stylesheet"/>

    <script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/behaviour/general.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/behaviour/voice-commands.js"></script>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>js/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
    <!-- toastr -->
    <script src="<%=basePath%>js/toastr/toastr.min.js" type="text/javascript"></script>

</head>
<body>
</body>
</html>
