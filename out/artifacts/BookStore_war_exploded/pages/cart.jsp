<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<%@ include file="common/head.jsp"%>
	<link rel="stylesheet" type="text/css" href="css/book_manager.css">
	<script type="text/javascript">
		$(function () {
			$(".deleteItem").click(function () {
				return confirm("确定删除：[ "+$(this).parent().parent().find("td:first").text()+" ]  ?");
			});

			$("#clearItems").click(function () {
				return confirm("确定清空购物车？");
			});
		})
	</script>
</head>
<body>
<div class="header">
    <span class="logo">
        BookStore
    </span>
	<span>购物车</span>
</div>
<div class="contain">
	<div id="bookContain">
		<table >
			<c:if test="${empty sessionScope.cart.items}">
				<tr><th>当前购物车还没有商品</th></tr>
				<tr><th><a href="">点击浏览商品</a></th></tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<tr id="#th">
					<th>商品名称</th><th>数量</th><th>单价</th><th>金额</th><th colspan="2">操作</th>
				</tr>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>${entry.value.count}</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a  href="" id="updateItems_${entry.value.id}" bookId="${entry.value.id}">修改</a></td>
						<script type="text/javascript">
							$("#updateItems_${entry.value.id}").click(function () {

								var boodId=$(this).attr("bookId");
								var prevCount=$(this).parent().parent().find("td:first").next().text();

								$(this).parent().parent().find("td:first").next().replaceWith(
										"<input type='text'  maxlength='8' style=' height=35px;width: 116px; #e3e3e3 solid;padding: 10px;' id='itemCount_${entry.value.id}'>"
								);
								$(this).parent().parent().find("td:first").next().val(prevCount);

								$(this).replaceWith(
										"<input type='button' value='提交修改' id='submitUpdate_${entry.value.id}'>"
										+"<input type='button' value='取消' id='cancelSubmit_${entry.value.id}'>"
								);
								$("#submitUpdate_${entry.value.id}").click(function () {
									var curCount=$(this).parent().parent().find("input:first").val();
									if(curCount==prevCount){
										location.href="pages/cart.jsp";
										return false;
									}
									var itemCount=$("#itemCount_${entry.value.id}").val();
									location.href="cartServlet?action=updateItem&id="+boodId+"&count="+itemCount;
								});

								$("#cancelSubmit_${entry.value.id}").click(function () {
									location.href="pages/cart.jsp";
								})
								return false;

							});
						</script>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
				<tr><td colspan="4">购物车中共有<span style="color: red">${sessionScope.cart.totalCount}</span>件商品
					总金额<span style="color: red">${sessionScope.cart.totalPrice}</span> 元</td>
					<td><a id="clearItems" href="cartServlet?action=clearItems">清空购物车</a></td>
					<td><a href="orderServlet?action=createOrder">去结账</a></td>
				</tr>
				<tr><th colspan="6"><a href="">继续浏览商品</a></th></tr>
			</c:if>
		</table>
	</div>
</div>
<%@include file="common/footer.jsp"%>
</body>
</html>