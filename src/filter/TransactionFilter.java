package filter;

import utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/15-22:23
 */


public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        } catch (IOException e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
