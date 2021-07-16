<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Tptogiar
  Date: 2021/7/9
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="pages/common/head.jsp"%>
    <script type="text/javascript">

        $(function () {
            alert("2");
            $("#test2").click(function () {
                alert("3");
                var $min= $('[name="min"]').val();
                alert($min);
            })
        });
    </script>
</head>
<body>
 <% request.setAttribute("test",new User()); %>


HelloWorld<br/>
${test}<br/>
 <br/>
 <br/>
${param.test}
test1
 <c:forEach begin="${null}" end="3" var="i">
     (${i})
 </c:forEach>
 test2
 <div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
 </div>
<input type="text" name="min" value="test">
<input type="button" id="test2">

<c:if test="ture">
    <c:if test="ture">

    </c:if>
</c:if


</body>
</html>
