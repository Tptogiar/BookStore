<%--
  Created by IntelliJ IDEA.
  User: Tptogiar
  Date: 2021/7/10
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath=request.getScheme()
        + "://"
        +request.getServerName()
        +":"
        +request.getServerPort()
        +request.getContextPath()
        +"/";%>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
