package web;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/07-20:36
 */


public class BookStoreServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("visitTest");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
