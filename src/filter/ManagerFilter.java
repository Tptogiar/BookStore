package filter;



import pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/15-19:04
 */


public class ManagerFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/pages/login.jsp").forward(request,servletResponse);
        }else{
            filterChain.doFilter(request,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
