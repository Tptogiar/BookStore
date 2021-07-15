<%--
  Created by IntelliJ IDEA.
  User: Tptogiar
  Date: 2021/7/15
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单查看</title>
    <%@include file="common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/book_manager.css">
</head>
<body>
<div class="header">
    <span class="logo">BookStore</span>
    <span>订单查看</span>
</div>
<div class="contain">
    <div id="bookContain">

        <table>
            <tr id="#th">
                <th>商品名称</th><th>数量</th><th>单价</th><th>金额</th>
            </tr>

            <tr><td colspan="4">您的订单号为：<span style="color: red">${sessionScope.orderId}</span></td></tr>



        </table>
    </div>
</div>






<%@include file="common/footer.jsp"%>
</body>
</html>
