<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${empty requestScope.book?"添加":"修改"}图书</title>
    <%@ include file="../common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/book_manager.css">
</head>
<body>
<div class="header">
    <span class="logo">
        BookStore
    </span>
    <span>${empty requestScope.book?"添加":"修改"}图书</span>
</div>
<div class="contain">
    <div id="bookContain">
        <table >
            <tr id="#th">
                <th>名称</th><th>价格</th><th>作者</th><th>销量</th><th>库存</th>
            </tr>
            <tr>
                <form action="manager/bookServlet" method="get">
                    <input type="hidden" name="action" value="${empty requestScope.book?"add":"edit"}">
                    <input type="hidden" name="id" value="${requestScope.book.id}">
                    <input type="hidden" name="pageNo" value="${param.pageNo}">
                    <td><input type="text"  name="name" value="${requestScope.book.name}" /></td>
                    <td><input type="text"  name="price" value="${requestScope.book.price}"/></td>
                    <td><input type="text"  name="author" value="${requestScope.book.author}"/></td>
                    <td><input type="text"  name="sales" value="${requestScope.book.sales}"/></td>
                    <td><input type="text"  name="stock" value="${requestScope.book.stock}"/></td>
                    <td><input type="submit" value="${empty requestScope.book?"添加":"修改"}"/></td>
                </form>
            </tr>
        </table>
    </div>
</div>
<%@include file="../../pages/common/footer.jsp"%>
</body>
</html>