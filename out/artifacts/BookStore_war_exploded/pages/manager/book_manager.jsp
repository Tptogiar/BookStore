<%@ page import="pojo.Book" %>
<%@ page import="pojo.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@ include file="../common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/book_manager.css">
</head>
<body>
<div class="header">
    <span class="logo">
        BookStore
    </span>
    <span>图书管理</span>
</div>
<div class="contain">
    <div id="bookContain">
        <table >
            <a href="pages/manager/book_edit.jsp"><input type="button" value="添加图书" ></a>
            <tr id="#th">
            <th>名称</th><th>价格</th><th>作者</th><th>销量</th><th>库存</th><th colspan="2">操作</th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.sales}</td>
                    <td>${book.stock}</td>
                    <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                    <td><a href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
<%--    <% pageContext.setAttribute("cur",((Page<Book>)request.getAttribute("page")).getPageNo()); %>--%>
<%--    <% pageContext.setAttribute("tol",((Page<Book>)request.getAttribute("page")).getPageTotal()); %>--%>
    <%@include file="../common/page_nav.jsp"%>
</div>
<%@include file="../../pages/common/footer.jsp"%>
</body>
</html>