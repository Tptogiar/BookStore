package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/11-10:09
 */


public class UserServlet extends BaseServlet {

    UserService userService= new UserServiceImpl();


    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        req.getSession().setAttribute("username",user.getUsername());
        req.getSession().setAttribute("email",user.getEmail());

        if(token!=null && token.equalsIgnoreCase(code)){
            if(userService.existsUsername(user.getUsername())){
//                resp.getWriter().print("用户名："+username+"  已经存在");
                System.out.println("用户名："+user.getUsername()+"  已经存在");
                req.getSession().setAttribute("registMsg","用户名已经存在");
                resp.sendRedirect(req.getContextPath()+"/pages/regist.jsp");
            }
            else if(userService.existsEmail(user.getEmail())){
                System.out.println("邮箱："+user.getEmail()+"  已经存在");
                req.getSession().setAttribute("registMsg","邮箱已经被注册");
                resp.sendRedirect(req.getContextPath()+"/pages/regist.jsp");
            }
            else{
                System.out.println("注册成功");
                userService.registUser(user);
                resp.sendRedirect("https://www.baidu.com");
            }
        }else{
            System.out.println("验证码："+code+"   不正确");

            req.getSession().setAttribute("registMsg","验证码不正确");
            resp.sendRedirect(req.getContextPath()+"/pages/regist.jsp");
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("接收到login请求");

        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        String code=req.getParameter("code");

        if(token!=null && token.equalsIgnoreCase(code)){
            User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
            User loginUser = userService.login(user);
            if (loginUser==null){
                System.out.println("登录失败"+"   "+user.getUsername());
                //用户回显用户名
                req.getSession().setAttribute("loginMsg","用户名或密码错误");
                req.getSession().setAttribute("username",user.getUsername());
                resp.sendRedirect(req.getContextPath()+"/pages/login.jsp");
            }else{
                System.out.println("登录成功");
//            resp.getWriter().println("登录成功");
                Cookie username = new Cookie("username", user.getUsername());
                username.setMaxAge(60*60*24*7);
                resp.addCookie(username);
                //用于登录后显示用户名
                req.getSession().setAttribute("user",user);
                resp.sendRedirect(req.getContextPath());
            }
        }else{
            req.getSession().setAttribute("loginMsg","验证码错误");
            resp.sendRedirect(req.getContextPath()+"/pages/login.jsp");
        }






    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        System.out.println("接收到logout请求");

        req.getSession().invalidate();

        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath());
    }


}
