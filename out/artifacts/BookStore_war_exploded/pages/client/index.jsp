<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <%@ include file="../common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div id="menu">
    <c:if test="${sessionScope.user.username ==null}">
        <a href="pages/login.jsp"><input type="button" value="登录" id="login"></a>
        <a href="pages/regist.jsp"><input type="button" value="注册" id="regist"></a>

    </c:if>
    <c:if test="${sessionScope.user.username !=null}">
        <span style="background-color: blanchedalmond;border-radius: 5px;"><a href="">${sessionScope.user.username}</a></span>
        <span><a href="userServlet?action=logout"><input type="button" value="登出"></a></span>
        <a href="pages/cart.jsp"><input type="button" value="查看购物车" id="cart"></a>
        <a href="manager/bookServlet?action=page"><input type="button" value="图书管理" ></a>
    </c:if>

</div>
<div class="header">
    <span class="logo">
        BookStore
    </span>
</div>
<div class="contain">
    <div id="book">
        <div id="filter">
            <form action="client/bookServlet" method="get">
                <input  type="hidden" name="action" value="pageByPrice">
                <input type="hidden" name="pageSize" value="4">
                <input type="hidden" name="pageNo" value="1">
                价格：<input type="text" style="width: 40px" name="min" value="${empty param.min?null:param.min}">-
                <input type="text" style="width: 40px" name="max" value="${empty param.max?null:param.max}">
                <input type="submit" value="查询" id="searchByPrice">
            </form>
        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <a href="cartServlet?action=addItem&id=${book.id}"><button>加入购物车</button></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    <br/><br/>
    <%@include file="../common/page_nav.jsp"%>
    </div>

</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>