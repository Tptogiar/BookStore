<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BookStore</title>
    <%@ include file="common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript">

        $(function () {

            $("#codeImg").click(function () {
                this.src="${basePath}kaptcha.jpg?"+new Date();
            });

            $("#regist").click(function () {

                var userName=$("#userName").val();
                var userNamePatt=/^\w{5,12}$/;
                if (!userNamePatt.test(userName)){
                    alert("用户名长度必须在5~12之间");
                    return false;
                }


                var userPassword=$("#password").val();
                var passwordPatt=/^\w{5,12}$/;
                if (!passwordPatt.test(userPassword)){
                    alert("密码长度必须在5~12之间");
                    return false;
                }

                var userPasswordAgain=$("#passwordAgain").val();
                if(userPassword!=userPasswordAgain){
                    alert("两次输入的密码不一致");
                    return false;
                }

                var email=$("#email").val();
                var emailPatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if(!emailPatt.test(email)){
                    alert("邮箱地址不合法");
                    return false;
                }

                var code=$.trim($("#code").val());
                if(code=null || code==""){
                    alert("验证码不正确");
                    return false;
                }

            });

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
        欢迎注册
    </div>
    <div id="card">

        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="regist">
            <h2>注册书城会员</h2>
            <span id="msg">
                ${sessionScope.registMsg}
            </span><br/><br/>
            <div >用户名称：<input name="username" type="text" placeholder="请输入用户名" id="userName"
                value="${sessionScope.username}">
            </div><br><br>
            <div>用户密码：<input name="password" type="password" placeholder="请输入密码" id="password"></div><br><br>
            <div>确认密码：<input type="password" placeholder="请再次确认密码" id="passwordAgain"></div><br><br>
            <div>电子邮箱：<input name="email" type="text" placeholder="请输入邮箱地址" id="email"
                value="${sessionScope.email}">
            </div><br><br>
            <div>验证码：<input name="code" type="text" placeholder="请输入验证码" id="code">
                <span><img id="codeImg" src="kaptcha.jpg"></span>
            </div><br><br>
            <input type="submit" value="注册" style="margin-left: 30%" id="regist">
        </form>


    </div>

</div>
<%@include file="common/footer.jsp"%>
</body>
</html>