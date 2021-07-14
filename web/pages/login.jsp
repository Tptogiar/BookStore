<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <%@ include file="common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript">
        $(function () {

            $("#codeImg").click(function () {
                this.src="${basePath}kaptcha.jpg?"+new Date();
            });


            $("#login").click(function () {
                var username=$("#username").val();
                var userNamePatt=/^\w{5,12}$/;
                if(! userNamePatt.test(username)){
                    alert("用户名长度必须在5    ~12之间");
                    return false;
                }

                var userPassword=$("#password").val();
                var passwordPatt=/^\w{5,12}$/;
                if (!passwordPatt.test(userPassword)){
                    alert("密码长度必须在 5~12之间");
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<div class="header">
    <span class="logo">
        BookStore
    </span>
</div>
<div class="contain">
    <div id="welcome">
        欢迎登录
    </div>
    <div id="card">
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="login">
            <h2>登录书城会员</h2>
            <span id="loginMsg">${empty sessionScope.loginMsg?"请输入用户名和密码":sessionScope.loginMsg}
            </span><br/><br/>
            <div><input name="username" type="text" placeholder="请输入用户名" id="username"
                        value="${empty sessionScope.username?cookie.username.value:sessionScope.username}">
            </div><br/><br/>
            <div><input name="password" type="password" placeholder="请输入密码"  id="password" ></div><br/>
            <div><input type="text" name="code" placeholder="请输入验证码" id="code">
                <span><img id="codeImg" src="kaptcha.jpg"></span>

            </div>
            <div><input type="submit" id="login" value="登录"></div><br/><br/>
        </form>
    </div>
</div>
<%@include file="common/footer.jsp"%>
</body>
</html>