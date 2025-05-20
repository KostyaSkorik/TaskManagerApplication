package by.kostya.filter;

import by.kostya.utils.URLPath;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(value = {URLPath.MAIN_PAGE_PATH, URLPath.CREATE_TASK_PATH, URLPath.SHOW_TASK_PATH})
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if( ((HttpServletRequest)servletRequest).getSession().getAttribute("user")==null){
            ((HttpServletResponse)servletResponse)
                    .sendRedirect(((HttpServletRequest) servletRequest).getContextPath()+URLPath.LOGIN_PATH);

        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
