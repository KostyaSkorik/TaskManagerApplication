package by.kostya.filter;


import by.kostya.entity.Priority;
import by.kostya.entity.Status;
import by.kostya.utils.URLPath;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(value = {URLPath.CREATE_TASK_PATH,URLPath.UPDATE_TASK_PATH,URLPath.SHOW_TASK_PATH})
public class CreateTaskAttributeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("priority", Priority.values());
        servletRequest.setAttribute("status", Status.values());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
