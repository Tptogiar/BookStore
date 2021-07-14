<%--
  Created by IntelliJ IDEA.
  User: Tptogiar
  Date: 2021/7/12
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
        <% String basePath2=request.getScheme()
            + "://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";%>
<base href="<%=basePath%>">
    <script type="text/javascript">
        $(function () {
            $("#pageToBtn").click(function () {
                var pageNo =$("#pageNoText").val();
                location="<%=basePath%>"+"client/bookServlet?action=page&pageNo="+pageNo;
            })
        });
    </script>

<div id="page_nav">
    <span>
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="${requestScope.page.url}&pageNo=1">首页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>
        <c:forEach begin="${requestScope.page.pageNo-2<0?0:requestScope.page.pageNo-2}"
                   end="${requestScope.page.pageNo+2}" var="i">
            <c:if test="${i>0&&i<=requestScope.page.pageTotal}">
                <c:if test="${i==requestScope.page.pageNo}">
                    <a style="font-weight: bold" href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
                <c:if test="${i!=requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:if>

        </c:forEach>
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>
        ,当前为第${requestScope.page.pageNo},共[${requestScope.page.pageTotal}]页，跳转到
        <input type="text" name="pageTo"  id="pageNoText" maxlength="4" style="width: 40px">
        <input type="button" id="pageToBtn" value="跳转">
    </span>
</div>
